package graphs;

public class MSTUnionFindN {
    Graph graph;

    class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    class Graph {
        int v;
        int e;
        Edge edges[];

        public Graph(int v, int e) {
            this.v = v;
            this.e = e;
            edges = new Edge[e];
        }
    }

    void createGraph() {
        graph = new Graph(3, 3);
        graph.edges[0].src = 0; graph.edges[0].dest = 1;
        graph.edges[1].src = 1; graph.edges[1].dest = 2;
        graph.edges[2].src = 2; graph.edges[2].dest = 0;
    }

    void detectCycle() {
        int [] parent = new int[] {-1, -1, -1};

        for (int i=0; i<graph.edges.length; i++) {
            int srcParent = find(graph.edges[i].src, parent);
            int destParent = find(graph.edges[i].dest, parent);
            if (srcParent == destParent) {
                System.out.println("Graph has a Cycle");
                break;
            }
            union(srcParent, destParent, parent);
        }

    }

    public static void main(String[] args) {

        
        MSTUnionFindN mstUnionFindN = new MSTUnionFindN();
    }

    void union(int srcRoot, int destRoot, int[] parent) {
        parent[srcRoot] = destRoot;
    }

    int find(int v, int[] parent) {
        if (parent[v] == -1) {
            return v;
        }
        return find(parent[v], parent);
    }
}