package SwordOffer.Array;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4.
 */
public class GetLeastNumbers {
    public static ArrayList<Integer> getLeastNumbers(int[] input, int k) {
        if (k > input.length) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int item : input) {
            heap.add(item);
        }
        for (int i = 0; i < k; i++) {
            result.add(heap.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> leastNumbers = getLeastNumbers(array, 10);
        for (Integer leastNumber : leastNumbers) {
            System.out.print(leastNumber + " ");
        }
    }
}
