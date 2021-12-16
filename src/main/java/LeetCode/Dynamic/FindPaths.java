package LeetCode.Dynamic;

public class FindPaths {
    private static final int INF = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long[][][] dp = new long[m][n][maxMove + 1];
        for (int k = 1; k <= maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (k == 1) {
                        if (i == 0) {
                            dp[i][j][k]++;
                        }
                        if (i == m - 1) {
                            dp[i][j][k]++;
                        }
                        if (j == 0) {
                            dp[i][j][k]++;
                        }
                        if (j == n - 1) {
                            dp[i][j][k]++;
                        }
                    } else {
                        if (i > 0) {
                            dp[i][j][k] += dp[i - 1][j][k - 1];
                            dp[i][j][k] %= INF;
                        }
                        if (i < m - 1) {
                            dp[i][j][k] += dp[i + 1][j][k - 1];
                            dp[i][j][k] %= INF;
                        }
                        if (j > 0) {
                            dp[i][j][k] += dp[i][j - 1][k - 1];
                            dp[i][j][k] %= INF;
                        }
                        if (j < n - 1) {
                            dp[i][j][k] += dp[i][j + 1][k - 1];
                            dp[i][j][k] %= INF;
                        }
                    }
                }
            }
        }
        long result = 0;
        for (int k = 1; k <= maxMove; k++) {
            result += dp[startRow][startColumn][k];
            result %= INF;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        FindPaths findPaths = new FindPaths();
        System.out.println(findPaths.findPaths(8, 50, 23, 5, 26));
    }
}
