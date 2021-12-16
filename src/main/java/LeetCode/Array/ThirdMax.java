package LeetCode.Array;

import java.util.PriorityQueue;

public class ThirdMax {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.equals(o2)) {
                return 0;
            } else if (o1 < o2) {
                return 1;
            } else {
                return -1;
            }
        });
        for (int num : nums) {
            priorityQueue.add(num);
        }
        if (priorityQueue.isEmpty()) {
            return -1;
        }
        int max = priorityQueue.poll();
        Integer lastMax = null;
        while (!priorityQueue.isEmpty()) {
            Integer now = priorityQueue.poll();
            if (lastMax == null && now != max) {
                lastMax = now;
            } else if (lastMax != null && !now.equals(lastMax)) {
                return now;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ThirdMax thirdMax = new ThirdMax();
        int result = thirdMax.thirdMax(new int[]{-2147483648, 1, 1});
        System.out.println(result);
    }
}
