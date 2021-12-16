package LeetCode.Simulation;

import java.util.*;

public class NumBusesToDestination {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        int n = routes.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        boolean[][] edges = new boolean[n][n];
        List<Integer> sourceList = new ArrayList<>();
        Set<Integer> targetSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int item : routes[i]) {
                set.add(item);
            }
            if (set.contains(source)) {
                sourceList.add(i);
            }
            if (set.contains(target)) {
                targetSet.add(i);
            }
            map.put(i, set);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (Integer item : map.get(i)) {
                    if (map.get(j).contains(item)) {
                        edges[i][j] = true;
                        edges[j][i] = true;
                    }
                }
            }
        }
        LinkedList<Integer> queue = new LinkedList<>(sourceList);
        int step = 0;
        Set<Integer> visited = new HashSet<>(queue);
        while (!queue.isEmpty()) {
            step++;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Integer now = queue.pollFirst();
                if (targetSet.contains(now)) {
                    return step;
                }
                for (int j = 0; j < n; j++) {
                    if (!visited.contains(j) && edges[now][j]) {
                        queue.addLast(j);
                        visited.add(j);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        NumBusesToDestination numBusesToDestination = new NumBusesToDestination();
        int[][] routers = new int[][]{{7,12},{4,5,15},{6},{15,19},{9,12,13}};
        int result = numBusesToDestination.numBusesToDestination(routers, 15, 12);
        System.out.println(result);
    }
}
