package LeetCode.String;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 1;
        for (int i = 0, j = 1; j < s.length(); j++) {
            for (int index = i; index < j; index++) {
                if (s.charAt(index) == s.charAt(j)) {
                    i = index + 1;
                    break;
                }
            }
            result = Math.max(result, j - i + 1);
        }
        return result;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, leftBound = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                leftBound = Math.max(leftBound, map.get(s.charAt(i)) + 1);
            }
            result = Math.max(result, i - leftBound + 1);
            map.put(s.charAt(i), i);
        }
        return result;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("qopubjguxhxdipfzwswybgfylqvjzhar"));
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("c"));
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("bbbbb"));
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"));
    }
}
