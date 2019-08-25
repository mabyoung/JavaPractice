package LeetCode.String;

public class StringToIntegerAtoi {
    public int atoi(String str) {
        str = str.trim();
        if ("".equals(str)) {
            return 0;
        }
        if (str.charAt(0) == '-') {
            return help(str.substring(1), false);
        } else if (str.charAt(0) == '+') {
            return help(str.substring(1), true);
        }
        return help(str, true);
    }

    private int help(String s, boolean isPositive) {
        long weight = 1;
        long result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' < 0 || s.charAt(i) - '0' > 9) {
                s = s.substring(0, i);
                break;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            result += weight * (s.charAt(i) - '0');
            weight *= 10;
        }
        if (isPositive) {
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        } else {
            if (-result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return isPositive ? (int) result : (int) -result;
    }

    public static void main(String[] args) {
        StringToIntegerAtoi stringToIntegerAtoi = new StringToIntegerAtoi();
        System.out.println(stringToIntegerAtoi.atoi("-2147483647"));
        System.out.println(stringToIntegerAtoi.atoi("-2147483649"));
        System.out.println(stringToIntegerAtoi.atoi("2147483648"));
        System.out.println(stringToIntegerAtoi.atoi("-2147483648"));
        System.out.println(stringToIntegerAtoi.atoi("-0012a42"));
    }
}
