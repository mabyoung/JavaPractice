package LeetCode;

public class CountGoodSubstrings {
    public int countGoodSubstrings(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 2; i < chars.length; i++) {
            if (chars[i] != chars[i-1] && chars[i] != chars[i-2] && chars[i-1] != chars[i-2]){
                result++;
            }
        }
        return result;
    }
}
