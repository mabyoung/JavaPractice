package LeetCode.Array;

public class SumOfBeauties {
    public int sumOfBeauties(int[] nums) {
        int result = 0;
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        max[0] = nums[0];
        min[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(nums[i], max[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            min[i] = Math.min(nums[i], min[i + 1]);
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > max[i - 1] && nums[i] < min[i + 1]) {
                result += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                result += 1;
            }
        }
        return result;
    }
}
