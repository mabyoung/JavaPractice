package LeetCode.Array;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int pre = 0;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxSum = Math.max(maxSum, pre);
        }
        return maxSum;
    }
}
