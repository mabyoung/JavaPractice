package LeetCode.String;

public class MaxPower {
    public int maxPower(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        char lastChar = chars[0];
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == lastChar) {
                count++;
            } else {
                result = Math.max(result, count);
                lastChar = chars[i];
                count = 1;
            }
        }
        result = Math.max(result, count);
        return result;
    }
}
