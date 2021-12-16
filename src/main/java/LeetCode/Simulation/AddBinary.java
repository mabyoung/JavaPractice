package LeetCode.Simulation;

public class AddBinary {
    public String addBinary(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carry = 0;
        int length = Math.max(a.length(), b.length());
        while (--length >= 0) {
            int valueA = indexA >= 0 ? (charsA[indexA--] - '0') : 0;
            int valueB = indexB >= 0 ? (charsB[indexB--] - '0') : 0;
            int sum = valueA + valueB + carry;
            if (sum <= 1) {
                stringBuilder.append(sum);
                carry = 0;
            } else {
                stringBuilder.append(sum - 2);
                carry = 1;
            }
        }
        if (carry > 0) {
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }
}
