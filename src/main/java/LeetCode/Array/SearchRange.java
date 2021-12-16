package LeetCode.Array;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int lessThan = getLessThan(nums, target);
        int moreThan = getMoreThan(nums, target);
        int[] result = new int[2];
        if (lessThan == -1 || nums[lessThan] != target) {
            result[0] = -1;
            result[1] = -1;
        } else {
            result[0] = moreThan;
            result[1] = lessThan;
        }
        return result;
    }

    public int getLessThan(int[] nums, int target) {
        if (nums.length == 0 || nums[0] > target) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int getMoreThan(int[] nums, int target) {
        if (nums.length == 0 || nums[nums.length - 1] < target) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
