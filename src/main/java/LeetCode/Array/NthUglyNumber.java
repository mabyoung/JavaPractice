package LeetCode.Array;

import java.util.*;

public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        List<Integer> primeList = Arrays.asList(2, 3, 5);
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        priorityQueue.add(1L);
        while (--n > 0) {
            Long now = priorityQueue.poll();
            for (Integer prime : primeList) {
                Long value = now * prime;
                if (!set.contains(value)) {
                    set.add(value);
                    priorityQueue.add(value);
                }
            }
        }
        return priorityQueue.poll().intValue();
    }
}
