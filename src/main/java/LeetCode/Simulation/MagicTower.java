package LeetCode.Simulation;

import java.util.PriorityQueue;

public class MagicTower {
    public int magicTower(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < 0) {
            return -1;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int result = 0;
        sum = 0;
        for (int num : nums) {
            sum += num;
            if (num < 0) {
                priorityQueue.add(-num);
            }
            while (sum < 0 && !priorityQueue.isEmpty()) {
                sum += priorityQueue.poll();
                result++;
            }
        }
        return result;
    }
}
