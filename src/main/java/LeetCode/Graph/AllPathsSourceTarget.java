package LeetCode.Graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathsSourceTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(graph, visited, 0, result, list);
        return result;
    }

    public void dfs(int[][] graph, boolean[] visited, int now, List<List<Integer>> result, List<Integer> list) {
        int n = visited.length;
        if (now == n - 1) {
            result.add(new ArrayList<>(list));
        } else {
            for (int item : graph[now]) {
                visited[item] = true;
                list.add(item);
                dfs(graph, visited, item, result, list);
                visited[item] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        AllPathsSourceTarget allPathsSourceTarget = new AllPathsSourceTarget();
        List<List<Integer>> result = allPathsSourceTarget.allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}});
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
