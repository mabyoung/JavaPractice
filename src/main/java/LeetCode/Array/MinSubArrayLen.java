package LeetCode.Array;

public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        long sum = nums[0];
        int result = Integer.MAX_VALUE;
        while (true) {
            if (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            } else {
                if (++right < nums.length) {
                    sum += nums[right];
                } else {
                    return result == Integer.MAX_VALUE ? 0 : result;
                }
            }
        }
    }

    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        System.out.println(minSubArrayLen.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
