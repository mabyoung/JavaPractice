package LeetCode.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EventualSafeNodes {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int n = graph.length;
        List<List<Integer>> rGraph = new ArrayList<>();
        int[] inDeg = new int[n];
        for (int i = 0; i < n; i++) {
            rGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int item : graph[i]) {
                rGraph.get(item).add(i);
            }
            inDeg[i] += graph[i].length;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer now = queue.pollFirst();
            for (Integer item : rGraph.get(now)) {
                if (--inDeg[item] == 0) {
                    queue.addLast(item);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }

}
