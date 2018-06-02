package graphs;

import list.LinkedList;

/**
 * Created by ts250370 on 7/28/17.
 */
public class GraphUnknown {
    LinkedList vertices = new LinkedList();
    int size = -1;

    void insertIntoGraph(Vertex v) {
        vertices.insertAtEndOfList(v);
    }

//    public void initializeUnknownGraph() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter Vertex and their adjescency vertices");
//        String input = sc.nextLine();
//
//        while (input != null && input.trim().length() > 0) {
//            String[] vertices = input.split(" ");
//            Vertex u = new Vertex(vertices[0]);
//            for (String vertex : Arrays.copyOfRange(vertices, 1, vertices.length)) {
//                u.adjescentVertices.insertAtEndOfList(new Vertex(vertex));
//            }
//            insertIntoGraph(u);
//            input = sc.nextLine();
//        }
//    }
//
//    public void printGraph() {
//        for (int i = 0; i < vertices.size(); i++) {
//            Vertex u = (Vertex) vertices.getAt(i);
//            System.out.print(u.label + " ::");
//
//            for (int j = 0; j < u.adjescentVertices.size(); j++) {
//                Vertex v = (Vertex) u.adjescentVertices.getAt(j);
//                System.out.print("->" + v.label);
//            }
//            System.out.println();
//        }
//    }
}
