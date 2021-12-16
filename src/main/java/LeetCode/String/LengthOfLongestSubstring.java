package LeetCode.String;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int max = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 1);
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            right++;
            Integer value = map.get(chars[right]);
            if (value == null || value == 0) {
                map.put(chars[right], 1);
            } else {
                while (chars[left] != chars[right]) {
                    map.remove(chars[left]);
                    left++;
                }
                map.put(chars[left], 1);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        int result = lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb");
        System.out.println(result);
    }
}
