package LeetCode.String;

public class AddBinary {
    //不补位
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carry = 0;
        while (indexA >= 0 || indexB >= 0) {
            int sum = carry;
            if (indexA >= 0) {
                sum += a.charAt(indexA--) - '0';
            }
            if (indexB >= 0) {
                sum += b.charAt(indexB--) - '0';
            }
            if (sum >= 2) {
                sum -= 2;
                carry = 1;
            } else {
                carry = 0;
            }
            result.append(sum);
        }
        if (carry == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }

    //使用补位的解法
    public String addBinary1(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        int maxLength = Math.max(lengthA, lengthB);
        if (lengthA < maxLength) {
            a = appendZero(a, maxLength - lengthA);
        }
        if (lengthB < maxLength) {
            b = appendZero(b, maxLength - lengthB);
        }
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        int carry = 0;
        for (int i = maxLength - 1; i >= 0; i--) {
            int now = arrayA[i] - '0' + arrayB[i] - '0' + carry;
            if (now >= 2) {
                now -= 2;
                carry = 1;
            } else {
                carry = 0;
            }
            arrayA[i] = (char) (now + '0');
        }
        StringBuilder result = new StringBuilder();
        if (carry == 1) {
            result.append(1);
        }
        for (char c : arrayA) {
            result.append(c);
        }
        return result.toString();
    }

    private String appendZero(String string, int zeroNum) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zeroNum; i++) {
            sb.append(0);
        }
        sb.append(string);
        return sb.toString();
    }

    //使用逆转的解法
    public String addBinary2(String a, String b) {
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        reverse(arrayA);
        reverse(arrayB);
        StringBuilder result = new StringBuilder();
        int aLength = a.length();
        int bLength = b.length();
        int carry = 0;
        for (int i = 0; i < Math.max(aLength, bLength); i++) {
            int now = carry;
            if (i < a.length()) {
                now += arrayA[i] - '0';
            }
            if (i < b.length()) {
                now += arrayB[i] - '0';
            }
            if (now >= 2) {
                result.append(now - 2);
                carry = 1;
            } else {
                carry = 0;
                result.append(now);
            }
        }
        if (carry > 0) {
            result.append(carry);
        }
        return reverse(result.toString());
    }

    private void reverse(char[] chars) {
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            char tmp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = tmp;
        }
    }

    private String reverse(String string) {
        StringBuilder result = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            result.append(string.charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("1010", "1011"));
    }
}
