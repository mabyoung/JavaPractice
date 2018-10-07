package SwordOffer.String;

public class StrToInt {
    public static int strToInt(String str) {
        if (str == null || str.trim().equals("")) {
            return 0;
        }
        int base = 1;
        int start = 0;
        int result = 0;
        char[] chars = str.toCharArray();
        switch (chars[0]) {
            case '+':
                start = 1;
                break;
            case '-':
                start = 1;
                base = -1;
                break;
            default:
                break;
        }
        for (int i = start; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                if (i == start) {
                    result = chars[i] - '0';
                } else {
                    result = result * 10 + chars[i] - '0';
                }
            } else {
                return 0;
            }
        }
        return base * result;
    }

    public static void main(String[] args) {
        System.out.println(strToInt(""));
    }
}
