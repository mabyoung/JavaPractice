package LeetCode.String;

public class ReverseStr {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int left = 0; left < chars.length; left += 2 * k) {
            int right = Math.min(chars.length - 1, left + k - 1);
            revert(chars, left, right);
        }
        return new String(chars);
    }

    public void revert(char[] chars, int left, int right) {
        while (left < right) {
            char tmp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        ReverseStr reverseStr = new ReverseStr();
        String result = reverseStr.reverseStr("abcdefg", 2);
        System.out.println(result);
    }
}
