package LeetCode.String;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.merge(c, 1, Integer::sum);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
