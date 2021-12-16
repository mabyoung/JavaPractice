package LeetCode.Array;

public class Jump {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        int index = 0;
        while (index < n) {
            for (int i = 1; i <= nums[index] && index + i < n; i++) {
                dp[index + i] = Math.min(dp[index + i], dp[index] + 1);
            }
            index++;
        }
        return dp[n - 1];
    }
}
