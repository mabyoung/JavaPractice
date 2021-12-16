package LeetCode.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) == t.charAt(i)) {
                continue;
            }
            if (set.contains(t.charAt(i))){
                return false;
            }
            map.put(s.charAt(i), t.charAt(i));
            set.add(t.charAt(i));
        }
        return true;
    }
}
