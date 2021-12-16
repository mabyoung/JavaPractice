package LeetCode.Num;

public class Reverse {
    public int reverse(int x) {
        if ((long) x < 0) {
            return -reversePositive(-(long) x);
        }
        return reversePositive(x);
    }

    public int reversePositive(long x) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(x));
        String reverse = stringBuilder.reverse().toString();
        long result = Long.parseLong(reverse);
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        System.out.println(reverse.reverse(-2147483648));
    }
}
