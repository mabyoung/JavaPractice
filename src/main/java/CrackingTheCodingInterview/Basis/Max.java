package CrackingTheCodingInterview.Basis;

/**
 * 请编写一个方法，找出两个数字中最大的那个。条件是不得使用if-else等比较和判断运算符。
 * 给定两个int a和b，请返回较大的一个数。若两数相同则返回任意一个。
 *
 * int正数右移31为全0，负数右移31为全1
 */
public class Max {
    public int getMax(int a, int b) {
        a = b - a;
        b -= a & (a >> 31);
        return b;
    }
}
