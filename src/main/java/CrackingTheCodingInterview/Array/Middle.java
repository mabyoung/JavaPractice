package CrackingTheCodingInterview.Array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Middle {
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    private void insert(int value) {
        if (minHeap.isEmpty() || value > minHeap.peek()) {
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            minHeap.add(value);
        } else if (maxHeap.isEmpty() || value < maxHeap.peek()) {
            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.poll());
            }
            maxHeap.add(value);
        } else {
            if (minHeap.size() < maxHeap.size()) {
                minHeap.add(value);
            } else {
                maxHeap.add(value);
            }
        }
    }

    private int getMiddle() {
        if (minHeap.size() < maxHeap.size()) {
            return maxHeap.peek();
        } else if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return Math.min(minHeap.peek(), maxHeap.peek());
        }
    }

    public int[] getMiddle(int[] A, int n) {
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            insert(A[i]);
            result[i] = getMiddle();
        }
        return result;
    }

    public static void main(String[] args) {
        Middle middle = new Middle();
        int[] result = middle.getMiddle(new int[]{216015,83379,204519,37493}, 6);
        for (int item : result) {
            System.out.println(item);
        }
    }
}
