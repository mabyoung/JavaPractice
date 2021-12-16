package LeetCode.Array;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class NthSuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1L);
        Set<Long> set = new HashSet<>();
        while (--n > 0) {
            Long now = priorityQueue.poll();
            for (int prime : primes) {
                long value = now * prime;
                if (!set.contains(value) && value > 0 && value <= Integer.MAX_VALUE) {
                    priorityQueue.add(value);
                    set.add(value);
                }
            }
        }
        return priorityQueue.poll().intValue();
    }


    public static void main(String[] args) {
        NthSuperUglyNumber nthSuperUglyNumber = new NthSuperUglyNumber();
        System.out.println(nthSuperUglyNumber.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }
}
