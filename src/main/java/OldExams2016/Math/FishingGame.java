package OldExams2016.Math;

import java.util.Scanner;

/**
 * 题目描述
 * ss请cc来家里钓鱼，鱼塘可划分为n＊m的格子，每个格子有不同的概率钓上鱼，cc一直在坐标(x,y)的格子钓鱼，而ss每分钟随机钓一个格子。
 * 问t分钟后他们谁至少钓到一条鱼的概率大？为多少？
 * 输入描述:
 * 第一行五个整数n,m,x,y,t(1≤n,m,t≤1000,1≤x≤n,1≤y≤m);
 * 接下来为一个n＊m的矩阵，每行m个一位小数，共n行，第i行第j个数代表坐标为(i,j)的格子钓到鱼的概率为p(0≤p≤1)
 * 输出描述:
 * 输出两行。第一行为概率大的人的名字(cc/ss/equal),第二行为这个概率(保留2位小数)
 */
public class FishingGame {
    public static double getMaxRate(double[][] pool, int x, int y, int t) {
        int n = pool.length;
        int m = pool[0].length;
        double ccRate = 1 - Math.pow(1 - pool[x - 1][y - 1], t);
        double poolSumRate = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                poolSumRate += pool[i][j];
            }
        }
        double poolAvgRate = poolSumRate / (n * m);
        double ssRate = 1 - Math.pow(1 - poolAvgRate, t);
        if (ccRate > ssRate) {
            System.out.println("cc");
            return ccRate;
        } else if (ccRate == ssRate) {
            System.out.println("equal");
            return ccRate;
        } else {
            System.out.println("ss");
            return ssRate;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int t = scanner.nextInt();
            scanner.nextLine();
            double[][] pool = new double[n][m];
            for (int i = 0; i < n; i++) {
                String[] content = scanner.nextLine().split(" ");
                for (int j = 0; j < m; j++) {
                    pool[i][j] = Double.parseDouble(content[j]);
                }
            }
            String maxRate = String.format("%.2f", getMaxRate(pool, x, y, t));
            System.out.println(maxRate);
        }
    }
}
