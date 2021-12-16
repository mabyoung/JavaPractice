package LeetCode.Dynamic;

/**
 * 664. 奇怪的打印机
 * 有台奇怪的打印机有以下两个特殊要求：
 * 打印机每次只能打印由 同一个字符 组成的序列。
 * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 * 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。
 * 链接：https://leetcode-cn.com/problems/strange-printer
 */
public class StrangePrinter {
    public int strangePrinter(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, dp[i][k] + dp[k+1][j]);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        StrangePrinter strangePrinter = new StrangePrinter();
        int result = strangePrinter.strangePrinter("aaabbb");
        System.out.println(result);
    }
}
