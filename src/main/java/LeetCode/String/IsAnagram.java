package LeetCode.String;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();
        for (char c : s.toCharArray()) {
            mapA.merge(c, 1, Integer::sum);
        }
        for (char c : t.toCharArray()) {
            mapB.merge(c, 1, Integer::sum);
        }
        for (Map.Entry<Character, Integer> entry : mapA.entrySet()) {
            Integer valueA = entry.getValue();
            Integer valueB = mapB.get(entry.getKey());
            if (!valueA.equals(valueB)) {
                return false;
            }
        }
        for (Map.Entry<Character, Integer> entry : mapB.entrySet()) {
            Integer valueA = mapA.get(entry.getKey());
            Integer valueB = entry.getValue();
            if (valueA == null || !valueA.equals(valueB)) {
                return false;
            }
        }
        return true;
    }
}
