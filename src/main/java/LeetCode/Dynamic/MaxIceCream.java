package LeetCode.Dynamic;

import java.util.Arrays;

public class MaxIceCream {
    //动态规划
    public int maxIceCream1(int[] costs, int coins) {
        int n = costs.length;
        int[][] dp = new int[coins + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= coins; i++) {
                if (i >= costs[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - costs[j - 1]][j - 1] + 1);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[coins][n];
    }

    //贪心算法
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        Arrays.sort(costs);
        int result = 0;
        for (int cost : costs) {
            if (cost > coins){
                return result;
            }
            coins -= cost;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        MaxIceCream maxIceCream = new MaxIceCream();
        int result = maxIceCream.maxIceCream(new int[]{1, 3, 2, 4, 1}, 7);
        System.out.println(result);
    }
}
