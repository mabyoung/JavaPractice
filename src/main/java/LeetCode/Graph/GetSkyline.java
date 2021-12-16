package LeetCode.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class GetSkyline {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> line = new ArrayList<>();
        for (int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            int high = building[2];
            line.add(new int[]{left, -high});
            line.add(new int[]{right, high});
        }
        line.sort((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        PriorityQueue<Integer> highQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        highQueue.add(0);
        int prev = 0;
        for (int[] ints : line) {
            int point = ints[0];
            int high = ints[1];
            if (high < 0) {
                highQueue.add(-high);
            } else {
                highQueue.remove(high);
            }
            Integer maxHigh = highQueue.peek();
            if (maxHigh != prev) {
                List<Integer> list = new ArrayList<>();
                list.add(point);
                list.add(maxHigh);
                prev = maxHigh;
                result.add(list);
            }
        }
        return result;
    }
}
