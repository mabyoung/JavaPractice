package LeetCode.Num;

public class MyAtoi {
    public int myAtoi(String s) {
        s = s.trim();
        long weight = 1;
        if (s.startsWith("+")) {
            s = s.substring(1);
        } else if (s.startsWith("-")) {
            weight = -1;
            s = s.substring(1);
        }
        long result = 0;
        for (char item : s.toCharArray()) {
            if (item < '0' || item > '9' || result > Integer.MAX_VALUE) {
                break;
            }
            result = result * 10 + (item - '0');
        }
        result *= weight;
        if (result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        }
        return (int) result;
    }
}
