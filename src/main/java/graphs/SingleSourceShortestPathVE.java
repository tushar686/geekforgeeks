package graphs;

import java.util.*;

public class SingleSourceShortestPathVE {

   public static void main(String[] args) {
       int [] vertices = new int[] {0, 1, 2, 3, 4};
       List<Integer>[] inAdj = new ArrayList[vertices.length];
       inAdj[0] = new ArrayList();
       inAdj[1] = new ArrayList();
       inAdj[1].add(0);
       inAdj[2] = new ArrayList();
       inAdj[2].add(0);
       inAdj[3] = new ArrayList();
       inAdj[3].add(2);
       inAdj[4] = new ArrayList();
       inAdj[4].add(1);
       inAdj[4].add(3);

       Map<String, Double> edges = new HashMap<>();
       edges.put("0-1", 0.5);
       edges.put("0-2", 0.1);
       edges.put("1-2", 0.2);
       edges.put("1-4", 2.0);
       edges.put("2-3", 0.6);
       edges.put("3-4", 0.1);

       SingleSourceShortestPathVE singleSourceShortestPath = new SingleSourceShortestPathVE();
       int [] path = singleSourceShortestPath.findSingleSourceShortesPath(vertices, inAdj, edges);

       int target = 4;

       while (target != 0) {
           System.out.print(target + "==>");
           target = path[target];
       }
       System.out.print("0");

   }

   public int[] findSingleSourceShortesPath(int[] vertices, List<Integer>[] inAdj, Map<String, Double> edges) {
       double[] distance = new double[vertices.length];
       int[] parent = new int[vertices.length];

       for (int i=0; i<distance.length; i++) {
           distance[i] = Integer.MAX_VALUE;
           parent[i] = -1;
       }

       distance[0] = 0;
       parent[0] = 0;

       for (int i=0; i<vertices.length-1; i++) {
            for (int j=0; j<vertices.length; j++) {
                for (int k=0; k<inAdj[j].size(); k++) {
                    int startVertexOfEdgeToJ = inAdj[j].get(k);
                    double edgeLengthToJ = edges.get(startVertexOfEdgeToJ + "-" + j);    
                    if (distance[j] > (distance[startVertexOfEdgeToJ] + edgeLengthToJ) ) {
                        distance[j] = distance[startVertexOfEdgeToJ] + edgeLengthToJ;
                        parent[j] = startVertexOfEdgeToJ;
                    }
                }
            }
        }

       return parent;

   }

}