package LeetCode.Simulation;

import java.util.PriorityQueue;

public class MaxmiumScore {
    public int maxmiumScore(int[] cards, int cnt) {
        PriorityQueue<Integer> queueA = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> queueB = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int card : cards) {
            if (card % 2 == 0) {
                queueB.add(card);
            } else {
                queueA.add(card);
            }
        }
        int result = 0;
        while (cnt > 0) {
            if (cnt % 2 == 1) {
                if (queueB.isEmpty()) {
                    return 0;
                }
                result += queueB.poll();
                cnt--;
            } else {
                if (queueA.size() < 2 && queueB.size() < 2) {
                    return 0;
                } else if (queueA.size() < 2) {
                    result += queueB.poll();
                    result += queueB.poll();
                    cnt -= 2;
                } else if (queueB.size() < 2) {
                    result += queueA.poll();
                    result += queueA.poll();
                    cnt -= 2;
                } else {
                    int sumA = getTwoSum(queueA);
                    int sumB = getTwoSum(queueB);
                    if (sumA >= sumB) {
                        result += queueA.poll();
                        result += queueA.poll();
                        cnt -= 2;
                    } else {
                        result += queueB.poll();
                        result += queueB.poll();
                        cnt -= 2;
                    }
                }
            }
        }
        return result;
    }

    public int getTwoSum(PriorityQueue<Integer> queue) {
        int a = queue.poll();
        int b = queue.peek();
        queue.add(a);
        return a + b;
    }
}
