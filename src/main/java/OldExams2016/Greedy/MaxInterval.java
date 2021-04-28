package OldExams2016.Greedy;

import java.util.Scanner;

/**
 * 题目描述
 * 给定一个递增序列，a1 <a2 <...<an 。定义这个序列的最大间隔为d=max{ai+1 - ai }(1≤i<n),现在要从a2 ,a3 ..an-1 中删除一个元素。问剩余序列的最大间隔最小是多少？
 * 输入描述:
 * 第一行，一个正整数n(1<=n<=100),序列长度;接下来n个小于1000的正整数，表示一个递增序列。
 * 输出描述:
 * 输出答案。
 */
public class MaxInterval {
    public static int getMaxInterval(int[] array) {
        int maxInterval = 0;
        for (int i = 1; i < array.length; i++) {
            maxInterval = Math.max(maxInterval, array[i] - array[i - 1]);
        }
        int minInterval = Integer.MAX_VALUE;
        for (int i = 2; i < array.length; i++) {
            minInterval = Math.min(minInterval, array[i] - array[i - 2]);
        }
        return Math.max(minInterval, maxInterval);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            System.out.println(getMaxInterval(array));
        }
    }
}
