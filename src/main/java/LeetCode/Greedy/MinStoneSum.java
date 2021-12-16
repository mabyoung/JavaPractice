package LeetCode.Greedy;

import java.util.PriorityQueue;

public class MinStoneSum {
    public int minStoneSum(int[] piles, int k) {
        long sum = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int pile : piles) {
            priorityQueue.add(pile);
            sum += pile;
        }
        for (int i = 0; i < k; i++) {
            Integer now = priorityQueue.poll();
            int deal = now / 2;
            priorityQueue.add(now - deal);
            sum -= deal;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        MinStoneSum minStoneSum = new MinStoneSum();
        System.out.println(minStoneSum.minStoneSum(new int[]{5, 4, 9}, 2));
    }
}
