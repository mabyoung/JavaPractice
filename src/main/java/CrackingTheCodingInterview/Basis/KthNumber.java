package CrackingTheCodingInterview.Basis;

/**
 * 有一些数的素因子只有3、5、7，请设计一个算法，找出其中的第k个数。
 * 给定一个数int k，请返回第k个数。保证k小于等于100。
 */
public class KthNumber {
    public int findKth(int k) {
        int[] num = new int[Math.max(k, 3)];
        num[0] = 3;
        num[1] = 5;
        num[2] = 7;
        int x3Index = 0;
        int x5Index = 0;
        int x7Index = 0;
        for (int i = 3; i < k; i++) {
            num[i] = Math.min(num[x3Index] * 3, Math.min(num[x5Index] * 5, num[x7Index] * 7));
            if (num[i] == num[x3Index] * 3) {
                x3Index++;
            }
            if (num[i] == num[x5Index] * 5) {
                x5Index++;
            }
            if (num[i] == num[x7Index] * 7) {
                x7Index++;
            }
        }
        return num[k - 1];
    }
}
