package LeetCode.Array;

public class DominantIndex {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = max1;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
                maxIndex = i;
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }
        return max1 >= 2 * max2 ? maxIndex : -1;
    }
}
