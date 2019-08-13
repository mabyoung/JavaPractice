package LeetCode.Array;

import java.util.Arrays;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array A =[1,1,2],
 * Your function should return length =2, and A is now[1,2].
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int result = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1]) {
                A[result++] = A[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int[] A = new int[]{1, 1, 2, 2, 3, 4};
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(A));
        System.out.println(Arrays.toString(A));
    }
}
