package LeetCode.Array;

import java.util.*;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int item : nums1) {
            set1.add(item);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int item : nums2) {
            if (set1.contains(item)) {
                set2.add(item);
            }
        }
        return set2.stream().mapToInt(i -> i).toArray();
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int item : nums1) {
            map1.merge(item, 1, Integer::sum);
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int item : nums2) {
            map2.merge(item, 1, Integer::sum);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            Integer value1 = entry.getValue();
            Integer value2 = map2.get(entry.getKey());
            if (value2 == null){
                value2 = 0;
            }
            int value = Math.min(value1, value2);
            for (int i = 0; i < value; i++) {
                list.add(entry.getKey());
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
