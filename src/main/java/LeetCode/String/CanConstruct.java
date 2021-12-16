package LeetCode.String;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            map1.merge(c, 1, Integer::sum);
        }
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map2.merge(c, 1, Integer::sum);
        }
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Integer value2 = map2.get(entry.getKey());
            if (value2 == null || entry.getValue() > value2) {
                return false;
            }
        }
        return true;
    }
}
