package LeetCode.Array;

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        for (int i = 1; i <= nums.length; i++) {
            left[i] = left[i - 1] + nums[i - 1];
            right[i] = right[i - 1] + nums[n - i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (left[i] == right[n - i - 1]) {
                return i;
            }
        }
        return -1;
    }
}
