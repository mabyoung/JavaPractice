package LeetCode.Array;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3→1,3,2
 * 3,2,1→1,2,3
 * 1,1,5→1,5,1
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        int i = num.length - 1;
        while (i > 0 && num[i] <= num[i - 1]) {
            i--;
        }
        if (i == 0) {
            reverse(num, 0, num.length - 1);
        } else {
            int j = num.length - 1;
            while (num[j] <= num[i - 1]) {
                j--;
            }
            int tmp = num[i - 1];
            num[i - 1] = num[j];
            num[j] = tmp;
            reverse(num, i, num.length - 1);
        }
    }

    private void reverse(int[] num, int begin, int end) {
        while (begin < end) {
            int tmp = num[begin];
            num[begin++] = num[end];
            num[end--] = tmp;
        }
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] num = new int[]{3, 1, 2};
        nextPermutation.nextPermutation(num);
        System.out.println(Arrays.toString(num));
    }
}
