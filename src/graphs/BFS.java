package graphs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by ts250370 on 7/28/17.
 */
public class BFS {

    Queue<Integer> queue = new ArrayDeque<>();
    Queue<Integer> path = new ArrayDeque<>();


    public static void main(String[] args) {
        GraphKnown graph = new GraphKnown();
        graph.initializeKnownGraph();
        graph.printGraph();

        BFS bfs = new BFS();
        bfs.doBFS(graph, 0);
    }

    public void doBFS(GraphKnown graph, int current) {
        Vertex vertex = graph.vertices[current];
        preProessIfRequired(graph, current, null);

        if(!vertex.processed) {
            process(vertex);
        }

        for(int j=0; j<vertex.adjacentVertices.length; j++) {
            int adjVertexIndex = vertex.adjacentVertices[j];
            preProessIfRequired(graph, adjVertexIndex, vertex);
        }

        if(!queue.isEmpty()) {
            doBFS(graph, queue.remove());
        }

    }

    public void process(Vertex vertex) {
        vertex.processed = true;
        System.out.printf("Process Label: %s Color: %s Discovered: %b\n", vertex.label, vertex.color, vertex.discovered);
        System.out.printf("%s==>%s\n", vertex.parent == null ? "Root" : vertex.parent.label, vertex.label);
    }

    void preProessIfRequired(GraphKnown graph, int index, Vertex parent) {
        Vertex vertex = graph.vertices[index];
        if(!vertex.discovered) {
            preProcess(vertex);
            vertex.discovered = true;
            vertex.parent = parent;
            queue.add(index);
        }
    }

    public void preProcess(Vertex vertex) {
        System.out.printf("PreProcess Label: %s Color: %s Discovered: %b\n", vertex.label, vertex.color, vertex.discovered);
    }

}
