package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubsequence {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : arr) {
            Integer value = map.get(item - difference);
            if (value == null) {
                map.put(item, 1);
            } else {
                Integer oldValue = map.get(item);
                if (oldValue == null) {
                    oldValue = 0;
                }
                if (value + 1 > oldValue) {
                    map.put(item, value + 1);
                }
            }
        }
        int max = 0;
        for (Integer value : map.values()) {
            max = Math.max(max, value);
        }
        return max;
    }
}
