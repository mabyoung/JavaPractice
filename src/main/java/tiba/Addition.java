package tiba;

/**
 * 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 * （字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
 */
public class Addition {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        char[] num1 = reverse(s);
        char[] num2 = reverse(t);
        int maxLength = Math.max(num1.length, num2.length);
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < maxLength; i++) {
            int int1 = i >= num1.length ? 0 : num1[i] - '0';
            int int2 = i >= num2.length ? 0 : num2[i] - '0';
            int sum = int1 + int2 + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            stringBuilder.append(sum);
        }
        if (carry > 0){
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }

    public char[] reverse(String str) {
        char[] result = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(str.length() - i - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Addition addition = new Addition();
        String result = addition.solve("1", "99");
        System.out.println(result);
    }
}
