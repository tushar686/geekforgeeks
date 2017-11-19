package graphs;

public class MSTUnionFindNPathCompression {

//    class Edge {
//        int src;
//        int dest;
//    }
//
//    class Subset {
//        int parent;
//        int rank;
//    }
//
//    class Graph {
//        int v;
//        int e;
//        Edge edges[];
//        Subset subsets[];
//
//        public Graph(int v, int e) {
//            this.v = v;
//            this.e = e;
//            this.subsets = new Subset[v];
//            this.edges = new Edge[e];
//            for (int i=0; i<e; ++i) {
//                edges[i] = new Edge();
//            }
//            //Make vertex as a parent of itself
//            for (int i=0; i<v; ++i) {
//                subsets[i] = i;
//            }
//
//        }
//    }
//
//    public static void main(String[] args) {
//        MSTUnionFindN mstUnionFindN = new MSTUnionFindN();
//
//        Graph graph = mstUnionFindN.new Graph(3, 3);
//        graph.edges[0].src = 0; graph.edges[0].dest = 1;
//        graph.edges[1].src = 1; graph.edges[1].dest = 2;
//        graph.edges[2].src = 2; graph.edges[2].dest = 0;
//
//        for (int i=0; i<graph.edges.length; i++) {
//            int srcParent = mstUnionFindN.find(graph.edges[i].src, graph.subsets);
//            int destParent = mstUnionFindN.find(graph.edges[i].dest, graph.subsets);
//            if (srcParent == destParent) {
//                System.out.println("Has Cycle");
//                break;
//            }
//            mstUnionFindN.union(i, graph);
//        }
//    }
//
//    void union(int e, Graph graph) {
//        int srcRoot = find(graph.edges[e].src, graph.subsets);
//        int destRoot = find(graph.edges[e].dest, graph.subsets);
//
//        if (graph.subsets[srcRoot].rank > graph.subsets[destRoot].rank) {
//            graph.subsets[destRoot].parent = srcRoot;
//        } else if (graph.subsets[srcRoot].rank < graph.subsets[destRoot].rank) {
//            graph.subsets[srcRoot].parent = destRoot;
//        } else {
//            graph.subsets[srcRoot].rank = graph.subsets[srcRoot].rank + 1;
//            graph.subsets[srcRoot].parent = destRoot;
//        }
//    }
//
//    int find(int v, Subset[] subsets) {
//        if (subsets[v].parent != v) {
//            subsets[v].parent = find(subsets[v].parent, subsets); //Make root as parent
//        }
//        return subsets[v].parent;
//    }
}