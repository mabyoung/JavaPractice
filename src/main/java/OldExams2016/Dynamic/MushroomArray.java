package OldExams2016.Dynamic;

import java.util.Scanner;

/**
 * 题目描述
 * 现在有两个好友A和B，住在一片长有蘑菇的由n＊m个方格组成的草地，A在(1,1),B在(n,m)。现在A想要拜访B，由于她只想去B的家，所以每次她只会走(i,j+1)或(i+1,j)这样的路线，在草地上有k个蘑菇种在格子里(多个蘑菇可能在同一方格),问：A如果每一步随机选择的话(若她在边界上，则只有一种选择)，那么她不碰到蘑菇走到B的家的概率是多少？
 * 输入描述:
 * 第一行N，M，K(1 ≤ N,M ≤ 20, k ≤ 100),N,M为草地大小，接下来K行，每行两个整数x，y，代表(x,y)处有一个蘑菇。
 * 输出描述:
 * 输出一行，代表所求概率(保留到2位小数)
 */
public class MushroomArray {
    public static double getRatio(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        double[][] dp = new double[n][m];
        for (int i = 0; i < n && board[i][0] != -1; i++) {
            if (i == 0) {
                dp[i][0] = 1;
            } else if (m == 1) {
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = dp[i - 1][0] * 0.5;
            }
        }
        for (int j = 0; j < m && board[0][j] != -1; j++) {
            if (j != 0) {
                if (n == 1){
                    dp[0][j] = dp[0][j - 1];
                } else {
                    dp[0][j] = dp[0][j - 1] * 0.5;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] == -1) {
                    dp[i][j] = 0;
                } else {
                    if (j == m - 1 && i == n - 1) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    } else if (j == m - 1) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] * 0.5;
                    } else if (i == n - 1) {
                        dp[i][j] = dp[i - 1][j] * 0.5 + dp[i][j - 1];
                    } else {
                        dp[i][j] = dp[i][j - 1] * 0.5 + dp[i - 1][j] * 0.5;
                    }
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] board = new int[n][m];
            for (int i = 0; i < k; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                board[x - 1][y - 1] = -1;
            }
            double ratio = getRatio(board);
            System.out.println(String.format("%.2f", ratio));
        }
    }
}
