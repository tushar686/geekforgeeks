package graphs;

/**
 * Created by ts250370 on 8/1/17.
 */
public class TwoEdgeConnectedGraph {
        int time= -1;
        int minBackEdge = Integer.MAX_VALUE;
        int startIndex = 0;

        public static void main(String[] args) {
            GraphKnown graph = new GraphKnown();
            graph.initializeKnownGraph();
            graph.printGraph();

            TwoEdgeConnectedGraph twoEdgeConnectedGraph = new TwoEdgeConnectedGraph();
            System.out.println(twoEdgeConnectedGraph.isTwoEdgeConnected(graph));
        }

        public boolean isTwoEdgeConnected(GraphKnown graph) {
            int minBackEdge = twoEdgeConnected(graph, startIndex);
            System.out.println(minBackEdge);
           return false;
        }

        private int twoEdgeConnected(GraphKnown graph, int currentIndex) {
            graph.vertices[currentIndex].entryTime = ++time;
            graph.vertices[currentIndex].discovered = true;
            if(startIndex != currentIndex)
                minBackEdge = graph.vertices[currentIndex].entryTime;

            for (int adjVertexIndex: graph.vertices[currentIndex].adjacentVertices) {
                if (!graph.vertices[adjVertexIndex].discovered) {
                    minBackEdge = Math.min(minBackEdge, twoEdgeConnected(graph, adjVertexIndex));
                } else {
                    if(adjVertexIndex != currentIndex) {
                        minBackEdge = Math.min(minBackEdge, graph.vertices[adjVertexIndex].entryTime);
                    }
                    return minBackEdge;
                }
            }
            return minBackEdge;
        }
}
