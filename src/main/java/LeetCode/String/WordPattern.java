package LeetCode.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        char[] patternChars = pattern.toCharArray();
        String[] words = s.split(" ");
        if (patternChars.length != words.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < patternChars.length; i++) {
            String value = map.get(patternChars[i]);
            if (value == null) {
                map.put(patternChars[i], words[i]);
            } else if (!value.equals(words[i])) {
                return false;
            }
        }
        Set<String> set = new HashSet<>();
        for (String value : map.values()) {
            if (set.contains(value)) {
                return false;
            }
            set.add(value);
        }
        return true;
    }
}
