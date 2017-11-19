package graphs;

import java.util.*;

import ds.Heap;

public class MinimumSpanningTreePrimsAlgo_Better_Graph_Structure {

    class Edge {
        int src;
        int dest;
        double weight;

        Edge(int src, int dest, double weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    class Graph {
        int v;
        int e;
        int[] vertices;
        Edge[] edges;
        List<Integer>[] adjVertices = new LinkedList[v];

        Graph(int noOfVertices, int noOfEdges) {
            this.v = noOfVertices;
            this.e = noOfEdges;

            int[] vertices = new int[v];
            Edge[] edges = new Edge[e];
        }

        Edge getEdge(int src, int dest) {
            for(Edge edge: edges) {
                if (src == edge.src && dest == edge.dest) {
                    return edge;
                }
            }
            return null;
        }
    }

    void createGraph(Graph graph) {
        for (int i=0; i<graph.v; i++) {
            graph.vertices[i] = i;
            graph.adjVertices[i] = new LinkedList();
        }

        graph.adjVertices[0].addAll(Arrays.asList(new Integer[]{1, 7}));
        graph.adjVertices[1].addAll(Arrays.asList(new Integer[]{0, 7, 2}));
        graph.adjVertices[2].addAll(Arrays.asList(new Integer[]{1, 8, 5, 3}));
        graph.adjVertices[3].addAll(Arrays.asList(new Integer[]{2, 5, 4}));
        graph.adjVertices[4].addAll(Arrays.asList(new Integer[]{5, 3}));
        graph.adjVertices[5].addAll(Arrays.asList(new Integer[]{6, 2, 3, 4}));
        graph.adjVertices[6].addAll(Arrays.asList(new Integer[]{7, 8, 5}));
        graph.adjVertices[7].addAll(Arrays.asList(new Integer[]{0, 1, 8, 6}));
        graph.adjVertices[8].addAll(Arrays.asList(new Integer[]{7, 2, 6}));

        graph.edges[0] = new Edge(0, 1, 4);
        graph.edges[1] = new Edge(0, 7, 8);
        graph.edges[2] = new Edge(1, 0, 4);
        graph.edges[3] = new Edge(1, 2, 8);
        graph.edges[4] = new Edge(1, 7, 11);
        graph.edges[5] = new Edge(2, 1, 8);
        graph.edges[6] = new Edge(2, 3, 7);
        graph.edges[7] = new Edge(2, 8, 2);
        graph.edges[8] = new Edge(2, 5, 4);
        graph.edges[9] = new Edge(3, 2, 7);
        graph.edges[10] = new Edge(3, 4, 9);
        graph.edges[11] = new Edge(3, 5, 14);
        graph.edges[12] = new Edge(4, 3, 9);
        graph.edges[13] = new Edge(4, 5, 10);
        graph.edges[14] = new Edge(5, 2, 4);
        graph.edges[15] = new Edge(5, 3, 14);
        graph.edges[16] = new Edge(5, 4, 10);
        graph.edges[17] = new Edge(5, 6, 2);
        graph.edges[18] = new Edge(6, 5, 2);
        graph.edges[19] = new Edge(6, 8, 6);
        graph.edges[20] = new Edge(6, 7, 1);
        graph.edges[21] = new Edge(7, 6, 1);
        graph.edges[22] = new Edge(7, 8, 7);
        graph.edges[23] = new Edge(7, 1, 11);
        graph.edges[24] = new Edge(7, 0, 8);
        graph.edges[25] = new Edge(8, 2, 2);
        graph.edges[26] = new Edge(8, 6, 6);
        graph.edges[27] = new Edge(8, 7, 7);    
    }


    public static void main(String[] args) {
        MinimumSpanningTreePrimsAlgo_Better_Graph_Structure mst = new MinimumSpanningTreePrimsAlgo_Better_Graph_Structure();
        Graph graph = mst.new Graph(8, 27);
        mst.createGraph(graph);
        mst.findMinimumSpanningTree(graph);
    }

    public void findMinimumSpanningTree(Graph graph) {
        boolean[] mst = new boolean[graph.v];
        double[] keysOnVertices = new double[graph.v];
        int[] parent = new int[graph.v];

        for (int i=0; i<graph.v; i++) {
            keysOnVertices[i] = Integer.MAX_VALUE; //Initialize keys on vertex to max
            mst[i] = false;
            parent[i] = -1; //intialize every vertex's parent to -1
        }

        keysOnVertices[0] = 0; //set ky on source vetex to min
        for (int i=0; i<graph.v-1; i++) { //Mininmum spanning tree will have n-1 edges
            int minVertexIndex = getMinWeightedVertexIndex(graph, keysOnVertices, mst);
            mst[minVertexIndex] = true;
            updateWeightOfAdjscentVertices(minVertexIndex, graph, keysOnVertices, parent, mst);
        }

        for (int i=0; i<graph.v; i++) {
            System.out.print(parent[i]);
            System.out.print(" <== " + i);
            System.out.println(" : " + graph.edges[i].weight);
        }

    }

    private void updateWeightOfAdjscentVertices(int minVertexIndex, Graph graph, double[] keysOnVertices, int[] parent, boolean[] mst) {
        for (Integer adjVertex : graph.adjVertices[minVertexIndex]) {
            Edge edgeFromMinVertexToAdjVertex = graph.getEdge(minVertexIndex, adjVertex);
            double edgeWeight = edgeFromMinVertexToAdjVertex.weight;
            if (keysOnVertices[adjVertex] > edgeWeight && !mst[adjVertex]) {
                keysOnVertices[adjVertex] = edgeWeight;
                parent[adjVertex] = minVertexIndex;
            }
        }
    }

    private int getMinWeightedVertexIndex(Graph graph, double[] keysOnVertices, boolean[] mst) {
        double keyOnMinVertex = Double.MAX_VALUE;
        int minVertexIndex = -1;
        for (int i=0; i<graph.v; i++) {
             if (keysOnVertices[i] < keyOnMinVertex && !mst[i]) {
                 minVertexIndex = i;
                 keyOnMinVertex = keysOnVertices[i];
             }
        }
        return minVertexIndex;
    }
 

}