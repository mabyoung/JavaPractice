package LeetCode.Array;

import java.util.Arrays;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] A = new int[]{1, 2, 3};
        System.out.println(removeElement.removeElement(A, 1));
        System.out.println(Arrays.toString(A));
    }
}
