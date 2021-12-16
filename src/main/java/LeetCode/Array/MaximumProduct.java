package LeetCode.Array;

import java.util.Arrays;

public class MaximumProduct {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }

    public static void main(String[] args) {
        MaximumProduct maximumProduct = new MaximumProduct();
        int result = maximumProduct.maximumProduct(new int[]{-100, -98, -1, 2, 3, 4});
        System.out.println(result);
    }
}
