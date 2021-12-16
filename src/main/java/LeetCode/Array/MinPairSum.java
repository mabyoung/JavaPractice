package LeetCode.Array;

import java.util.Arrays;

public class MinPairSum {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            result = Math.max(result, nums[left++] + nums[right--]);
        }
        return result;
    }
}
