package LeetCode.Array;

public class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int right = 0;
        int max = nums[right];
        for (int i = right; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                right = i;
            }
        }
        int left = nums.length - 1;
        int min = nums[left];
        for (int i = left; i >= 0; i--) {
            if (nums[i] <= min) {
                min = nums[i];
            } else {
                left = i;
            }
        }
        if (left >= right){
            return 0;
        }
        return right - left + 1;
    }
}
