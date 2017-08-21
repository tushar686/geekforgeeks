package algobook.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by ts250370 on 7/28/17.
 */
public class DFS {
    int time = 0;

    public static void main(String[] args) {
        GraphKnown graph = new GraphKnown();
        graph.initializeKnownGraph();
        graph.printGraph();

        DFS dfs = new DFS();
        dfs.doDFS(graph, 0);
        graph.printGraph();
    }

    public void doDFS(GraphKnown graph, int current) {
        Vertex vertex = graph.vertices[current];

        preProcess(vertex, null);
        for(int j=0; j<vertex.adjacentVertices.length; j++) {
            int adjVertexIndex = vertex.adjacentVertices[j];
            if(!graph.vertices[adjVertexIndex].processed) {
//                graph.vertices[adjVertexIndex].treeEdges = current -> adjVertexIndex
                doDFS(graph, adjVertexIndex);
            } else {
//                graph.vertices[adjVertexIndex].backEdges = adjVertexIndex -> current
            }
        }
        postProcess(vertex);

    }

    public void postProcess(Vertex vertex) {
        vertex.exitTime = ++time;
        System.out.printf("PostProcess Label: %s \n", vertex.label);
//        System.out.printf("Process Label: %s Color: %s Discovered: %b\n", vertex.label, vertex.color, vertex.discovered);
//        System.out.printf("%s==>%s\n", vertex.parent == null ? "Root" : vertex.parent.label, vertex.label);
    }

    void preProcess(Vertex current, Vertex parent) {
        current.processed = true;
        current.parent = parent;
        current.entryTime = ++time;
        System.out.printf("PreProcess Label: %s \n", current.label);
    }

}