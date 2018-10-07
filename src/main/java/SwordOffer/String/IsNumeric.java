package SwordOffer.String;

public class IsNumeric {
    public static boolean isNumeric(char[] str) {
        boolean decimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                if (i == str.length - 1 || hasE) {
                    return false;
                }
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                if (!(i == 0 || (str[i - 1] == 'e' || str[i - 1] == 'E'))) {
                    return false;
                }
            } else if (str[i] == '.') {
                if (hasE || decimal) {
                    return false;
                }
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNumeric("1+23".toCharArray()));
    }
}
