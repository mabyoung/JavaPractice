package LeetCode.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ShortestPathLength {
    public class Soul {
        int value;
        long visited;
        int distance;

        Soul(int value, long visited, int distance) {
            this.value = value;
            this.visited = visited;
            this.distance = distance;
        }
    }

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.min(result, bfs(graph, i));
        }
        return result;
    }

    public int bfs(int[][] graph, int start) {
        int n = graph.length;
        LinkedList<Soul> queue = new LinkedList<>();
        Soul soul = new Soul(start, visitTarget(0, start), 0);
        queue.add(soul);
        Set<String> set = new HashSet<>();
        set.add(buildTag(soul.value, soul.visited));
        while (!queue.isEmpty()) {
            Soul now = queue.pollFirst();
            if (isAllVisited(now.visited, n)) {
                return now.distance;
            }
            for (int item : graph[now.value]) {
                long visited = visitTarget(now.visited, item);
                String tag = buildTag(item, visited);
                if (!set.contains(tag)) {
                    set.add(tag);
                    queue.addLast(new Soul(item, visited, now.distance + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public boolean isAllVisited(long visited, int n) {
        long value = (1 << (n)) - 1;
        return visited == value;
    }

    public long visitTarget(long visited, int target) {
        if ((visited & (1 << target)) == 0) {
            return visited + (1 << target);
        }
        return visited;
    }

    public String buildTag(int value, long visited) {
        return value + "_" + visited;
    }

    public static void main(String[] args) {
        ShortestPathLength shortestPathLength = new ShortestPathLength();
        System.out.println(shortestPathLength.shortestPathLength(new int[][]{{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}}));
    }
}
