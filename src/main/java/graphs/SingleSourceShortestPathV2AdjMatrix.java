package graphs;

import java.util.*;

public class SingleSourceShortestPathV2AdjMatrix {

   public static void main(String[] args) {
       int[][] vertices = new int[][]{
               {0, 1, 1, 0, 0},
               {0, 0, 1, 0, 1},
               {0, 0, 0, 1, 0},
               {0, 0, 0, 0, 1},
               {0, 0, 0, 0, 0},
   };
       Map<String, Double> edges = new HashMap<>();
       edges.put("0-1", 1.1);
       edges.put("0-2", 0.5);
       edges.put("1-2", 1.0);
       edges.put("1-4", 2.5);
       edges.put("2-3", 2.0);
       edges.put("3-4", 0.1);

       SingleSourceShortestPathV2AdjMatrix singleSourceShortestPath = new SingleSourceShortestPathV2AdjMatrix();
       int [] path = singleSourceShortestPath.findSingleSourceShortesPath(vertices, edges);

       int target = 4;

       while (target != 0) {
           System.out.print(target + "==>");
           target = path[target];
       }
       System.out.print("0");

   }

   public int[] findSingleSourceShortesPath(int[][] vertices, Map<String, Double> edges) {
       double[] distance = new double[vertices.length];
       int[] parent = new int[vertices.length];
       Set<Integer> path = new HashSet<>();

       for (int i=0; i<distance.length; i++) {
           distance[i] = Integer.MAX_VALUE;
           parent[i] = -1;
       }

       distance[0] = 0;
       parent[0] = 0;

       for (int i=0; i<vertices.length; i++) {
           int minVertexIndex = getMinDistanceVertexIndex(vertices, distance, path);
           path.add(minVertexIndex);
           updateAdjVerticesDistance(minVertexIndex, vertices, parent, distance, edges, path);
       }

       return parent;

   }

   private void updateAdjVerticesDistance(int minVertexIndex, int[][] vertices, int[] parent, double[] distance, Map<String, Double> edges, Set<Integer> path) {
       for (int i=0; i<vertices.length; i++) {
           if (vertices[minVertexIndex][i] == 1) {
               int adjVertex = i;
               if (!path.contains(adjVertex)) {
                   double edgeLenghtFromMinVertex = (Double) edges.get(minVertexIndex + "-" + adjVertex);
                   if (distance[adjVertex] > (distance[minVertexIndex] + edgeLenghtFromMinVertex)) {
                       distance[adjVertex] = distance[minVertexIndex] + edgeLenghtFromMinVertex;
                       parent[adjVertex] = minVertexIndex;
                   }
               }
           }
       }
   }

   private int getMinDistanceVertexIndex(int[][] vertices, double[] distance, Set<Integer> path) {
       double minVertexLength = Double.MAX_VALUE;
       int minVertexIndex = 0;
       for (int i=0; i<vertices.length; i++) {
            if (distance[i] < minVertexLength && !path.contains(i)) {
                minVertexIndex = i;
                minVertexLength = distance[i];
            }
       }
       return minVertexIndex;
   }

}