package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ds.Heap;

public class MinimumSpanningTreePrimsAlgo {
    
    public static void main(String[] args) {
        int [] vertices = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[][] adj = new int[vertices.length][];
        adj[0] = new int[]{1, 7};
        adj[1] = new int[]{0, 7, 2};
        adj[2] = new int[]{1, 8, 5, 3};
        adj[3] = new int[]{2, 5, 4};
        adj[4] = new int[]{5, 3};
        adj[5] = new int[]{6, 2, 3, 4};
        adj[6] = new int[]{7, 8, 5};
        adj[7] = new int[]{0, 1, 8, 6};
        adj[8] = new int[]{7, 2, 6};
 
        Map<String, Integer> edges = new HashMap<>();
        edges.put("0-1", 4);
        edges.put("0-7", 8);
        edges.put("1-0", 4);
        edges.put("1-2", 8);
        edges.put("1-7", 11);
        edges.put("2-1", 8);
        edges.put("2-3", 7);
        edges.put("2-8", 2);
        edges.put("2-5", 4);
        edges.put("3-2", 7);
        edges.put("3-4", 9);
        edges.put("3-5", 14);
        edges.put("4-3", 9);
        edges.put("4-5", 10);
        edges.put("5-2", 4);
        edges.put("5-3", 14);
        edges.put("5-4", 10);
        edges.put("5-6", 2);
        edges.put("6-5", 2);
        edges.put("6-8", 6);
        edges.put("6-7", 1);
        edges.put("7-6", 1);
        edges.put("7-8", 7);
        edges.put("7-1", 11);
        edges.put("7-0", 8);
        edges.put("8-2", 2);
        edges.put("8-6", 6);
        edges.put("8-7", 7);

        MinimumSpanningTreePrimsAlgo mst = new MinimumSpanningTreePrimsAlgo();
        mst.findMinimumSpanningTree(vertices, adj, edges);
    }

    public void findMinimumSpanningTree(int[] vertices, int[][] adj, Map<String, Integer> edges) {
        Set<Integer> mst = new HashSet<>();
        int[] weights = new int[vertices.length];
        int[] parent = new int[vertices.length];
        for (int i=1; i<weights.length; i++) { 
            weights[i] = Integer.MAX_VALUE; 
            parent[i] = -1;
        }

        weights[0] = 0;
        parent[0] = -1;

        for (int i=0; i<vertices.length-1; i++) { //Mininmum spanning tree will have n-1 edges
            int minVertexIndex = getMinWeightedVertexIndex(vertices, weights, mst);
            mst.add(minVertexIndex);
            updateWeightOfAdjscentVertices(minVertexIndex, adj, weights, edges, parent, mst);
        }

        for (int i=0; i<vertices.length; i++) {
            System.out.print(parent[i]);
            System.out.print(" <== " + i);
            System.out.println(" : " + weights[i]);
        }

    }

    private void updateWeightOfAdjscentVertices(int minVertexIndex, int[][] adj, int[] weights, Map<String, Integer> edges, int[] parent, Set<Integer> mst) {
        for (int i=0; i<adj[minVertexIndex].length; i++) {
            int adjVertex = adj[minVertexIndex][i];
            int edgeLength = edges.get(minVertexIndex + "-" + adjVertex);

            if (weights[adjVertex] > edgeLength && !mst.contains(adjVertex)) {
                weights[adjVertex] = edgeLength;
                parent[adjVertex] = minVertexIndex;
            }
        }
    }

    private int getMinWeightedVertexIndex(int[] vertices, int[] weights, Set<Integer> mst) {
        int minVertexWeight = Integer.MAX_VALUE;
        int minVertexIndex = -1;
        for (int i=0; i<vertices.length; i++) {
             if (weights[i] < minVertexWeight && !mst.contains(i)) {
                 minVertexIndex = i;
                 minVertexWeight = weights[i];
             }
        }
        return minVertexIndex;
    }
 

}