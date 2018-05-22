package graphs;

import java.util.HashMap;
import java.util.Map;

public class DetectCycleInDirectedGraph {
    public static void main(String [] args) {
        int[][] graph = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 2, 3, 0, 0, 0},
            {0, 0, 0, 3, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 5, 0},
            {0, 0, 0, 0, 0, 0, 6},
            {0, 0, 0, 0, 4, 0, 0}
        };
        boolean[] white = new boolean[graph.length];
        boolean[] gray = new boolean[graph.length];
        boolean[] black = new boolean[graph.length];
        for (int i=0; i<graph.length; i++) {
            white[i] = true;
        }

        DetectCycleInDirectedGraph detectCycleInDirectedGraph = new DetectCycleInDirectedGraph();

        boolean result = false;
        Map<Integer, Integer> trackMap = new HashMap<>();
        for (int i=0; i<graph.length && !result; i++) {
            if (white[i]) {
                result = detectCycleInDirectedGraph.isCycle(i, graph, white, gray, black, trackMap);
            }
        }
        System.out.println("Is there a cycle in this graph: " + result);

    }

    boolean isCycle(int start, int[][] graph, boolean[] white, boolean[]  gray, boolean[] black, Map<Integer, Integer> trackMap) {
        if (white[start]) {
            white[start] = false;
            gray[start] = true;

            for (int i=0; i<graph.length; i++) {
                if (graph[start][i] != 0 ) {
                    if (gray[i]) { // this is backedge; start is pointing to i which also being visited
                        Integer cyclePoint = i;
                        System.out.print(start);
                        System.out.print("-->" + i);

                        Integer adj = trackMap.get(start);
                        while (adj != i) {
                            System.out.print("-->" + adj);
                            adj = trackMap.get(adj);
                        }
                        System.out.print("-->" + start);
                        System.out.println();
                        return true;
                    } else {
                        trackMap.put(i, start);
                        return isCycle(i, graph, white, gray, black, trackMap);
                    }
                }
            }
            black[start] = true;
        }

        return false;
    }
}
