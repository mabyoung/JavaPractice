package LeetCode.String;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder stringBuilder1 = new StringBuilder(num1).reverse();
        StringBuilder stringBuilder2 = new StringBuilder(num2).reverse();
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        int length = Math.max(stringBuilder1.length(), stringBuilder2.length());
        for (int i = 0; i < length; i++) {
            int a = i >= stringBuilder1.length() ? 0 : stringBuilder1.charAt(i) - '0';
            int b = i >= stringBuilder2.length() ? 0 : stringBuilder2.charAt(i) - '0';
            int sum = a + b + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            stringBuilder.append(sum);
        }
        if (carry > 0) {
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }

}
