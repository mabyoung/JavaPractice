package tiba;

public class StringReverse {
    /**
     * 反转字符串
     *
     * @param str string字符串
     * @return string字符串
     */
    public String solve(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = tmp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        StringReverse stringReverse = new StringReverse();
        String result = stringReverse.solve("abcd");
        System.out.println(result);
    }
}
