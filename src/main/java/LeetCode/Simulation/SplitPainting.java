package LeetCode.Simulation;

import java.util.*;

public class SplitPainting {
    public List<List<Long>> splitPainting(int[][] segments) {
        Map<Integer, Long> map = new HashMap<>();
        for (int[] segment : segments) {
            int left = segment[0];
            int right = segment[1];
            long color = segment[2];
            map.merge(left, color, Long::sum);
            if (map.get(right) == null) {
                map.put(right, -color);
            } else {
                map.put(right, map.get(right) - color);
            }
        }
        List<List<Long>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        long colorSum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                List<Long> last = result.get(i - 1);
                last.add((long) list.get(i));
                last.add(colorSum);
            }
            if (i < list.size() - 1) {
                List<Long> next = new ArrayList<>();
                next.add((long) list.get(i));
                result.add(next);
                colorSum += map.get(list.get(i));
            }
        }
        result.removeIf(item -> item.get(2) == 0);
        return result;
    }

    public static void main(String[] args) {
        SplitPainting splitPainting = new SplitPainting();
        List<List<Long>> result = splitPainting.splitPainting(new int[][]{{1, 4, 5}, {4, 7, 7}, {1, 7, 9}});
        for (List<Long> item : result) {
            System.out.println(item);
        }
    }
}
