package LeetCode.Dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxPoints {
    public long maxPoints(int[][] points) {
        long result = 0;
        int m = points.length;
        int n = points[0].length;
        long[][] dp = new long[m][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = points[0][j];
        }
        long[] left = new long[n];
        long[] right = new long[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Math.max(left[j], right[j]) + points[i][j];
            }
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    left[j] = dp[i][j];
                } else {
                    left[j] = Math.max(left[j - 1] - 1, dp[i][j]);
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (j == n - 1) {
                    right[j] = dp[i][j];
                } else {
                    right[j] = Math.max(right[j + 1] - 1, dp[i][j]);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxPoints maxPoints = new MaxPoints();
        long result = maxPoints.maxPoints(new int[][]{{5, 2, 1, 2}, {2, 1, 5, 2}, {5, 5, 5, 0}});
        System.out.println(result);

    }
}
