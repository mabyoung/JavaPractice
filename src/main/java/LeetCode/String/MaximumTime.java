package LeetCode.String;

public class MaximumTime {
    public String maximumTime(String time) {
        char[] chars = time.toCharArray();
        if (chars[0] == '?') {
            chars[0] = chars[1] <= '3' || chars[1] == '?' ? '2' : '1';
        }
        if (chars[1] == '?') {
            chars[1] = chars[0] == '2' ? '3' : '9';
        }
        if (chars[3] == '?') {
            chars[3] = '5';
        }
        if (chars[4] == '?') {
            chars[4] = '9';
        }
        return new String(chars);
    }
}
