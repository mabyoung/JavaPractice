package OldExams2016.Simulation;

import java.util.Scanner;

/**
 * 一只兔子藏身于20个圆形排列的洞中（洞从1开始编号），一只狼从x号洞开始找,下次隔一个洞找(即在x＋2号洞找)，在下次个两个洞找(即在x＋5号洞找)，它找了n次仍然没有找到。问兔子可能在那些洞中。
 * 输入描述:
 * 输入有多组数据，每组数据一行两个整数分别为x和n(x <= 20,n <= 100000)
 * 输出描述:
 * 每组数据一行按从小到大的顺序输出兔子可能在的洞，数字之间用空格隔开。若每个洞都不肯能藏着兔子，输出-1。
 */
public class RabbitHidingHole {
    public static String getPossibleHole(int x, int n) {
        int[] hole = new int[20];
        int index = x - 1;
        for (int i = 0; i < n; i++) {
            hole[index] = 1;
            index = (index + i + 2) % 20;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            if (hole[i] == 0) {
                stringBuilder.append(i + 1).append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(getPossibleHole(x, n));
        }
    }
}
