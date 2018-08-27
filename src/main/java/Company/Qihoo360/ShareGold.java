package Company.Qihoo360;

import java.util.Arrays;

/**
 * A、B两伙马贼意外地在一片沙漠中发现了一处金矿，双方都想独占金矿，但各自的实力都不足以吞下对方。
 * 经过谈判后，双方同意用一个公平的方式来处理这片金矿。
 * 处理的规则如下：他们把整个金矿分成n段，由A、B开始轮流从最左端或最右端占据一段，直到分完为止。
 * 马贼A想提前知道他们能分到多少金子，因此请你帮忙计算他们最后各自拥有多少金子?（两伙马贼均会采取对己方有利的策略）
 */
public class ShareGold {
    public static int[] shareGold(int[] gold) {
        int[][] dp = new int[gold.length][gold.length];
        int[] sum = new int[gold.length];
        for (int i = 0; i < gold.length; i++) {
            dp[i][i] = gold[i];
            if (i == 0) {
                sum[i] = gold[i];
            } else {
                sum[i] = gold[i] + sum[i - 1];
            }
        }
        for (int i = 1; i < gold.length; i++) {
            for (int j = 0; j + i < gold.length; j++) {
                if (j == 0) {
                    dp[j][j + i] = sum[j + i] - Math.min(dp[j + 1][j + i], dp[j][j + i - 1]);
                } else {
                    dp[j][j + i] = sum[j + i] - sum[j - 1] - Math.min(dp[j + 1][j + i], dp[j][j + i - 1]);
                }
            }
        }
        int[] result = new int[2];
        result[0] = dp[0][gold.length - 1];
        result[1] = sum[gold.length - 1] - result[0];
        return result;
    }

    public static void main(String[] args) {
        int[] gold = {140,649,340,982,105,86,56,610,340,879};
        int[] result = shareGold(gold);
        System.out.println(Arrays.toString(result));
    }
}
