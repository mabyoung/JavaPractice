package LeetCode.String;

public class Multiply {
    public String multiply(String num1, String num2) {
        String result = "0";
        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            StringBuilder stringBuilder = new StringBuilder(multiply(num2, a));
            for (int j = 0; j < num1.length() - 1 - i; j++) {
                stringBuilder.append("0");
            }
            result = sum(result, stringBuilder.toString());
        }
        return result;
    }

    public String multiply(String num1, int num2) {
        String result = "0";
        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(a * num2));
            for (int j = 0; j < num1.length() - 1 - i; j++) {
                stringBuilder.append("0");
            }
            result = sum(result, stringBuilder.toString());
        }
        return result;
    }

    public String sum(String num1, String num2) {
        StringBuilder stringBuilder1 = new StringBuilder(num1).reverse();
        StringBuilder stringBuilder2 = new StringBuilder(num2).reverse();
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        int carry = 0;
        while (index < stringBuilder1.length() || index < stringBuilder2.length()) {
            int a = index < stringBuilder1.length() ? stringBuilder1.charAt(index) - '0' : 0;
            int b = index < stringBuilder2.length() ? stringBuilder2.charAt(index) - '0' : 0;
            int sum = a + b + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            stringBuilder.append(sum);
            index++;
        }
        if (carry > 0) {
            stringBuilder.append(carry);
        }
        String result = stringBuilder.reverse().toString();
        int firstNotZero = getFirstNotZero(result);
        if (firstNotZero == -1) {
            return "0";
        } else {
            return result.substring(firstNotZero);
        }
    }

    public int getFirstNotZero(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        System.out.println(multiply.multiply("123", "2"));
    }
}
