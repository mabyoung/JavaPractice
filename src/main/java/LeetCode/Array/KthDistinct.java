package LeetCode.Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KthDistinct {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.merge(s, 1, Integer::sum);
        }
        Set<String> set = new HashSet<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                set.add(entry.getKey());
            }
        }
        int index = 0;
        for (String s : arr) {
            if (set.contains(s)) {
                index++;
            }
            if (index == k) {
                return s;
            }
        }
        return "";
    }
}
