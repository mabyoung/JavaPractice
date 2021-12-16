package LeetCode.String;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        int result = 0;
        for (Integer value : map.values()) {
            if (value % 2 == 0) {
                result += value;
            } else {
                result += value - 1;
            }
        }
        if (result < s.length()) {
            return result + 1;
        }
        return result;
    }
}
