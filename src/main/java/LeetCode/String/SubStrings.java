package LeetCode.String;

public class SubStrings {
    public String multiply(String num1, String num2) {
        if (num1.charAt(0) == '+') {
            num1 = num1.substring(1);
        }
        if (num2.charAt(0) == '+') {
            num2 = num2.substring(1);
        }
        if (num1.charAt(0) == '-' && num2.charAt(0) == '-') {
            return plus(num1.substring(1), num2.substring(1));
        } else if (num1.charAt(0) == '-') {
            return minus(num2, num1.substring(1));
        } else if (num2.charAt(0) == '-') {
            return minus(num1, num2.substring(1));
        }
        return plus(num1, num2);
    }

    public String addZero(String num, int maxLength) {
        StringBuilder num1Builder = new StringBuilder(num);
        while (num1Builder.length() < maxLength) {
            num1Builder.insert(0, "0");
        }
        return num1Builder.toString();
    }

    public String plus(String num1, String num2) {
        int maxLength = Math.max(num1.length(), num2.length());
        char[] result = new char[maxLength];
        num1 = addZero(num1, maxLength);
        num2 = addZero(num2, maxLength);
        int carry = 0;
        for (int i = maxLength - 1; i >= 0; i--) {
            int sum = carry + num1.charAt(i) - '0' + num2.charAt(i) - '0';
            if (sum > 10) {
                carry = 1;
                result[i] = (char) (sum - 10 + '0');
            } else {
                carry = 0;
                result[i] = (char) (sum + '0');
            }
        }
        if (carry == 1) {
            return "1" + new String(result);
        } else {
            return new String(result);
        }
    }

    public boolean bigger(String num1, String num2) {
        if (num1.length() == num2.length()) {
            for (int i = 0; i < num1.length(); i++) {
                if (num1.charAt(i) != num2.charAt(i)) {
                    return num1.charAt(i) > num2.charAt(i);
                }
            }
        }
        return num1.length() > num2.length();
    }

    public String minus(String num1, String num2) {
        if (bigger(num1, num2)) {
            return minusHelper(num1, num2);
        }
        return "-" + minusHelper(num2, num1);
    }

    public String minusHelper(String num1, String num2) {
        int maxLength = Math.max(num1.length(), num2.length());
        char[] result = new char[maxLength];
        num1 = addZero(num1, maxLength);
        num2 = addZero(num2, maxLength);
        int borrow = 0;
        for (int i = maxLength - 1; i >= 0; i--) {
            int sum = num1.charAt(i) - num2.charAt(i) - borrow;
            if (sum < 0) {
                result[i] = (char) (sum + 10 + '0');
                borrow = 1;
            } else {
                result[i] = (char) (sum + '0');
                borrow = 0;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;
        for (char c : result) {
            if (c == '0' && flag) {
                flag = false;
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        SubStrings multiplyStrings = new SubStrings();
        System.out.println(multiplyStrings.multiply("1", "1"));
    }
}
