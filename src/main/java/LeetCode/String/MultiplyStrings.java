package LeetCode.String;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int[] tmp = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                tmp[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int carry = 0;
        for (int i = tmp.length - 1; i >= 0; i--) {
            carry += tmp[i];
            tmp[i] = carry % 10;
            carry = carry / 10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean zeroFlag = true;
        for (int item : tmp) {
            if (item != 0) {
                zeroFlag = false;
            }
            if (!zeroFlag) {
                stringBuilder.append(item);
            }
        }
        return stringBuilder.toString().equals("") ? "0" : stringBuilder.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply("0", "0"));
    }
}
