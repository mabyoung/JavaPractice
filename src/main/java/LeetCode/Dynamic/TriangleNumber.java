package LeetCode.Dynamic;

import java.util.Arrays;

public class TriangleNumber {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int k = i + 2;
            for (int j = i + 1; j < n - 1; j++) {
                while (k < n && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                ans += Math.max(k - j - 1, 0);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TriangleNumber triangleNumber = new TriangleNumber();
        System.out.println(triangleNumber.triangleNumber(new int[]{1, 2, 3, 4}));
    }

}
