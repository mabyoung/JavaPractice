package LeetCode.String;

public class BalancedStringSplit {
    public int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        int lCount = 0;
        int rCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'L') {
                lCount++;
            } else {
                rCount++;
            }
            if (lCount == rCount) {
                result++;
                lCount = 0;
                rCount = 0;
            }
        }
        return result;
    }
}
