package LeetCode.Num;

public class MinNonZeroProduct {
    public int minNonZeroProduct(int p) {
        if (p == 1) {
            return 1;
        }
        if (p == 2) {
            return 6;
        }
        long right = (long) Math.pow(2, p) - 1;
        long result = 1;
        right--;
        long value = right % 1000000007;
        result = pow(value, right / 2);
        result *= ((long) Math.pow(2, p) - 1) % 1000000007;
        result %= 1000000007;
        return (int) result;
    }

    public long pow(long a, long b) {
        if (b == 0) {
            return 1;
        }
        long pow = pow(a, b / 2);
        if (b % 2 == 0) {
            return (pow * pow) % 1000000007;
        } else {
            return ((pow * pow) % 1000000007 * a) % 1000000007;
        }
    }
    public static void main(String[] args) {
        MinNonZeroProduct minNonZeroProduct = new MinNonZeroProduct();
        for (int i = 30; i <= 60; i++) {
            System.out.println(minNonZeroProduct.minNonZeroProduct(i));

        }
    }
}
