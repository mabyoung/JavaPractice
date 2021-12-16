package LeetCode.Array;

import java.util.PriorityQueue;

public class LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.add(num);
        }
        if (priorityQueue.isEmpty()) {
            return 0;
        }
        while (k-- > 0) {
            priorityQueue.add(-priorityQueue.poll());
        }
        int result = 0;
        for (Integer item : priorityQueue) {
            result += item;
        }
        return result;
    }
}
