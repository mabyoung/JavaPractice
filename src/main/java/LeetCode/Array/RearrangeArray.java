package LeetCode.Array;

import java.util.Arrays;

public class RearrangeArray {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        for (int i = 0; i < nums.length; i+=2) {
            result[i] = nums[left++];
            if (i+1 < nums.length){
                result[i+1] = nums[right--];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RearrangeArray rearrangeArray = new RearrangeArray();
        int[] result = rearrangeArray.rearrangeArray(new int[]{1, 2, 3, 4, 5});
        for (int item : result) {
            System.out.println(item);
        }
    }
}
