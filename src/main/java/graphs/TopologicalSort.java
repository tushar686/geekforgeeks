package graphs;


import java.util.Stack;

/**
 * Created by ts250370 on 2/3/18.
 */
public class TopologicalSort {

    public static void main(String[] args) {
        int[][] graph = {
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0}
        };

        int[] visited = new int[7];
        Stack<Integer> topoSort = new Stack();

        for (int i=0; i<graph.length; i++) {
            findTopologicalSort(graph, visited, topoSort, i);
        }

        topoSort.stream().forEach(System.out::println);
    }

    private static void findTopologicalSort(int[][] graph, int[] visited, Stack<Integer> topoSort, int start) {

        if (visited[start] == 0) {
            visited[start] = 1;
            for (int i = 0; i < graph.length; i++) {
                if (graph[start][i] > 0 && visited[i] == 0) {
                    findTopologicalSort(graph, visited, topoSort, i);
                }
            }
            topoSort.add(start);
        }

    }
}
