package LeetCode.Simulation;

public class GetMoneyAmount {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                dp[j][j + i] = getMin(dp, j, j + i);
            }
        }
        return dp[1][n];
    }

    public int getMin(int[][] dp, int x, int y) {
        if (x == y - 1) {
            return x;
        }
        int min = Integer.MAX_VALUE;
        for (int i = x + 1; i < y; i++) {
            min = Math.min(min, Math.max(dp[x][i - 1], dp[i + 1][y]) + i);
        }
        return min;
    }

    public static void main(String[] args) {
        GetMoneyAmount getMoneyAmount = new GetMoneyAmount();
        int result = getMoneyAmount.getMoneyAmount(10);
        System.out.println(result);
    }
}
