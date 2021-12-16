package LeetCode.String;

import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : s.toCharArray()) {
            map1.merge(c, 1, Integer::sum);
        }
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : t.toCharArray()) {
            map2.merge(c, 1, Integer::sum);
        }
        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            Integer value1 = map1.get(entry.getKey());
            Integer value2 = entry.getValue();
            if (value1 == null) {
                value1 = 0;
            }
            if (value1 + 1 == value2) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
