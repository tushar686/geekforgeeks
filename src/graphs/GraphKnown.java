package algobook.graphs;

import java.util.Scanner;

/**
 * Created by ts250370 on 7/28/17.
 */
public class GraphKnown {
    Vertex[] vertices;
    int noOfVertices;
    int size = -1;

    public void initializeKnownGraph() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Vertices");
        noOfVertices = Integer.parseInt(sc.nextLine());
        vertices = new Vertex[noOfVertices];

        for(int i=0; i<noOfVertices; i++) {
            Vertex vertex = new Vertex(i);
            vertices[i] = vertex;
            System.out.println("Enter degree and adjacent vertices for: " + i);
            String[] inDegAdj = sc.nextLine().split(" ");
            int[] adjVertices = new int[Integer.parseInt(inDegAdj[0])];
            for(int j=0; j<adjVertices.length; j++) {
                adjVertices[j] = Integer.parseInt(inDegAdj[j+1]);;
            }
            vertex.adjacentVertices = adjVertices;
        }
    }


    public void printGraph() {
        for (int i = 0; i < noOfVertices; i++) {
            if(vertices[i].entryTime > 0)
                System.out.print(vertices[i].label + " ( " + vertices[i].entryTime + " , " + vertices[i].exitTime + " ) ::");
            else
                System.out.print(vertices[i].label + " ::");
            for (int j = 0; j < vertices[i].adjacentVertices.length; j++) {
                System.out.print("->" + vertices[i].adjacentVertices[j]);
            }
            System.out.println();
        }
    }

}
