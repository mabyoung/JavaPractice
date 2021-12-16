package LeetCode.Dynamic;

public class ProfitableSchemes {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][][] dp = new int[group.length + 1][n + 1][minProfit + 1];
        for (int i = 0; i < n; i++) {
            dp[0][i][0] = 1;
        }
        for (int i = 1; i <= group.length; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    if (j >= group[i - 1]) {
                        dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - group[i - 1]][Math.max(0, k - profit[i - 1])];
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                    if (dp[i][j][k] >= (int) 1e9 + 7) {
                        dp[i][j][k] -= (int) 1e9 + 7;
                    }
                }
            }
        }
        return dp[group.length][n][minProfit];
    }

    public static void main(String[] args) {
        ProfitableSchemes profitableSchemes = new ProfitableSchemes();
        int result = profitableSchemes.profitableSchemes(5, 3, new int[]{2,2}, new int[]{2,3});
        System.out.println(result);
    }
}
