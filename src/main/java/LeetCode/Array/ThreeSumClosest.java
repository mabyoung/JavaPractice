package LeetCode.Array;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = Integer.MAX_VALUE / 2;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int lessThan = getLessThan(nums, target - nums[i] - nums[j], j + 1, n - 1);
                int moreThan = getMoreThan(nums, target - nums[i] - nums[j], j + 1, n - 1);
                if (lessThan != -1 && Math.abs(nums[i] + nums[j] + nums[lessThan] - target) < Math.abs(result - target)) {
                    result = nums[i] + nums[j] + nums[lessThan];
                }
                if (moreThan != -1 && Math.abs(nums[i] + nums[j] + nums[moreThan] - target) < Math.abs(result - target)) {
                    result = nums[i] + nums[j] + nums[moreThan];
                }
            }
        }
        return result;
    }

    public int getLessThan(int[] nums, int target, int left, int right) {
        if (nums[left] > target) {
            return -1;
        }
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public int getMoreThan(int[] nums, int target, int left, int right) {
        if (nums[right] < target) {
            return -1;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
