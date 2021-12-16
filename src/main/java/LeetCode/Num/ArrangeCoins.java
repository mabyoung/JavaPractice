package LeetCode.Num;

public class ArrangeCoins {
    public int arrangeCoins(int n) {
        int i = 1;
        long sum = 0;
        while (sum <= n) {
            sum += i;
            i++;
        }
        return i - 2;
    }
}
