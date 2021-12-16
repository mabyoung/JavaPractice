package LeetCode.Num;

import java.util.Arrays;

public class NumSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        for (int i = 1; i <= n; i++) {
            double sqrt = Math.sqrt(i);
            if (sqrt == (int) sqrt) {
                dp[i] = 1;
                continue;
            }
            for (int j = 1; j <= sqrt; j++) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        int result = numSquares.numSquares(12);
        System.out.println(result);
    }
}
