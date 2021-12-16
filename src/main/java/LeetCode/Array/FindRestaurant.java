package LeetCode.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            Integer value = map.get(list2[i]);
            if (value != null) {
                minIndex = Math.min(minIndex, value + i);
            }
        }
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            Integer value = map.get(list2[i]);
            if (value != null && value + i == minIndex) {
                resultList.add(list2[i]);
            }
        }
        return resultList.toArray(new String[0]);
    }
}
