package graphs;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AllPathsFromSourceToDest {

    public static void main(String[] args) {
        long start = Calendar.getInstance().getTimeInMillis();
        AllPathsFromSourceToDest solution = new AllPathsFromSourceToDest();

        List<List<Integer>> result = solution.allPathsSourceTarget(new int[][]{
            {1,2},
                {3},
                {3},
                {}
        });
        System.out.println(result);

        result = solution.allPathsSourceTarget(new int[][]{     //[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
                {4,3,1},
                {3,2,4},
                {3},
                {4},
                {}
        });
        System.out.println(result);

        result = solution.allPathsSourceTarget(new int[][]{
                {}
        });
        System.out.println(result);
        result = solution.allPathsSourceTarget(null);
        System.out.println(result);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> paths = new ArrayList<>();
        if (graph == null) {
            return paths;
        }
        if (graph.length == 1) {
            List<Integer> path = new ArrayList<>();
            path.add(0);
            paths.add(path);
            return paths;
        }

        List<Integer> path = new ArrayList<>();
        findPath(graph, paths, path, 0, graph.length - 1);

        return paths;
    }

    void findPath(int[][] graph, List<List<Integer>> paths, List<Integer> path, int start, int end) {
        if (start == end) {
            path.add(end);
            List<Integer> temp = new ArrayList<>(path);
            paths.add(temp);
            return;
        }
        path.add(start);
        int[] adjVertices = graph[start];
        for (int adjVertex : adjVertices) {
            findPath(graph, paths, path, adjVertex, end);
            path.remove(path.size()-1);
        }
    }
}