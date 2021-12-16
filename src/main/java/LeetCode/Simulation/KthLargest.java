package LeetCode.Simulation;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> priorityQueue;
    int kth;

    public KthLargest(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>();
        kth = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        priorityQueue.add(val);
        while (priorityQueue.size() > kth) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }

    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
