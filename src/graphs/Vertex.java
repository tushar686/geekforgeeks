package algobook.graphs;

/**
 * Created by ts250370 on 7/28/17.
 */
public class Vertex {
    int label;
    int[] adjacentVertices;
    int treeEdges[];
    int backEdges[];
    int entryTime;
    int exitTime;
    boolean discovered;
    boolean processed;
    Vertex parent;
    String color;

    Vertex(int label) {
        this.label = label;
        discovered = false;
    }

}
