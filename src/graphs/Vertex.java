package graphs;

/**
 * Created by ts250370 on 7/28/17.
 */
public class Vertex {
    public int label;
    public int[] adjacentVertices;
    public int treeEdges[];
    public int backEdges[];
    public int entryTime;
    public int exitTime;
    public boolean discovered;
    public boolean processed;
    public Vertex parent;
    public String color;

    public Vertex(int label) {
        this.label = label;
        discovered = false;
    }

    public String toString() {
        return (char)label + " " + discovered;
    }

}
