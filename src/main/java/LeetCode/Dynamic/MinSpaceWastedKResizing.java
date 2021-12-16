package LeetCode.Dynamic;

import java.util.Arrays;

public class MinSpaceWastedKResizing {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        int n = nums.length;
        if (k + 1 >= n) {
            return 0;
        }
        int min = getMin(nums);
        int max = getMax(nums);
        int s = max - min + 1;
        int[][][] dp = new int[n][k + 1][s];
        for (int a = 0; a < n; a++) {
            for (int b = 0; b <= k; b++) {
                Arrays.fill(dp[a][b], Integer.MAX_VALUE);
            }
        }
        for (int c = nums[0]; c < s; c++) {
            dp[0][0][c] = c + min - nums[0];
        }
        for (int a = 1; a < n; a++) {
            for (int b = 0; b <= k; b++) {
                for (int c = nums[a]-min; c < s; c++) {
                    if (b > 0) {
                        int d1 = dp[a - 1][b][c];
                        if (d1 != Integer.MAX_VALUE) {
                            d1 += (c + min - nums[a]);
                        }
                        int d2 = getMin(dp[a - 1][b - 1]);
                        if (d2 != Integer.MAX_VALUE) {
                            d2 += (c + min - nums[a]);
                        }
                        dp[a][b][c] = Math.min(d1, d2);
                    } else {
                        int d1 = dp[a - 1][b][c];
                        if (d1 != Integer.MAX_VALUE) {
                            d1 += (c + min - nums[a]);
                        }
                        dp[a][b][c] = d1;
                    }
                }
            }
        }
        return getMin(dp[n - 1][k]);
    }

    public int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public int getMin(int[] nums) {
        int min = nums[0];
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinSpaceWastedKResizing minSpaceWastedKResizing = new MinSpaceWastedKResizing();
        System.out.println(minSpaceWastedKResizing.minSpaceWastedKResizing(new int[]{823928,975967,995846,998485,999437,999889,999945,999988,999991,999999,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000}, 86));
        System.out.println(minSpaceWastedKResizing.minSpaceWastedKResizing(new int[]{10, 20}, 0));
        System.out.println(minSpaceWastedKResizing.minSpaceWastedKResizing(new int[]{10, 20, 30}, 1));
        System.out.println(minSpaceWastedKResizing.minSpaceWastedKResizing(new int[]{10, 20, 15, 30, 20}, 2));

    }
}
