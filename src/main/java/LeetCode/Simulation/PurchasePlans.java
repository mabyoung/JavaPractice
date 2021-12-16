package LeetCode.Simulation;

import java.util.Arrays;

public class PurchasePlans {
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] * 2 > target) {
                break;
            }
            int targetIndex = getTargetIndex(nums, target - nums[i], i + 1, nums.length - 1);
            result = (result + targetIndex - i) % 1000000007;
        }
        return result;
    }

    public int getTargetIndex(int[] nums, int target, int left, int right) {
        if (left > right || nums[left] > target){
            return left - 1;
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

    public static void main(String[] args) {
        PurchasePlans purchasePlans = new PurchasePlans();
        int result = purchasePlans.purchasePlans(new int[]{2, 5, 3, 5}, 6);
        System.out.println(result);
    }
}
