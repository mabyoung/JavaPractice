package Company.Tencent;

import java.util.Scanner;

/**
 * 小Q有X首长度为A的不同的歌和Y首长度为B的不同的歌，现在小Q想用这些歌组成一个总长度正好为K的歌单。
 * 每首歌最多只能在歌单中出现一次，在不考虑歌单内歌曲的先后顺序的情况下，请问有多少种组成歌单的方法。
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含一个整数，表示歌单的总长度K(1<=K<=1000)。
 * 接下来的一行包含四个正整数，分别表示歌的第一种长度A(A<=10)和数量X(X<=100)以及歌的第二种长度B(B<=10)和数量Y(Y<=100)。保证A不等于B。
 * 输出一个整数,表示组成歌单的方法取模。因为答案可能会很大,输出对1000000007取模的结果。
 */
public class Main {
    public static int ox;
    public static int oy;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        int a = scan.nextInt();
        int x = scan.nextInt();
        int b = scan.nextInt();
        int y = scan.nextInt();
        ox = x;
        oy = y;
        long count = getCount(k, a, x, b, y);
        System.out.println(count / 2 % 1000000007);
    }

    static long getCount(int k, int a, int x, int b, int y) {
        if (k < 0) {
            return 0;
        }
        if (k == 0) {
            int cox = 1;
            int cheng = ox;
            int chu = ox - x;
            for (int i = 0; i < ox - x; i++) {
                cox = cox * cheng;
                cheng--;
                cox = cox / chu;
                chu--;
            }
            cheng = oy;
            chu = oy - y;
            for (int i = 0; i < oy - y; i++) {
                cox = cox * cheng;
                cheng--;
                cox = cox / chu;
                chu--;
            }
            return cox;
        }
        if (x <= 0 && y <= 0) {
            return 0;
        }
        if (x <= 0) {
            return getCount(k - b, a, x, b, y - 1);
        }
        if (y <= 0) {
            return getCount(k - a, a, x - 1, b, y);
        }
        return getCount(k - b, a, x, b, y - 1) + getCount(k - a, a, x - 1, b, y);
    }

}
