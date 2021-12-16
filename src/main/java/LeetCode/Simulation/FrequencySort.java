package LeetCode.Simulation;

import java.util.*;

public class FrequencySort {
    public class ItemWithFrequency{
        char item;
        int frequency;
    }

    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char item : chars) {
            map.merge(item, 1, Integer::sum);
        }
        List<ItemWithFrequency> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            ItemWithFrequency temp = new ItemWithFrequency();
            temp.item = entry.getKey();
            temp.frequency = entry.getValue();
            list.add(temp);
        }
        list.sort((o1, o2) -> o2.frequency-o1.frequency);
        for (ItemWithFrequency itemWithFrequency : list) {
            for (int i = 0; i < itemWithFrequency.frequency; i++) {
                stringBuilder.append(itemWithFrequency.item);
            }
        }
        return stringBuilder.toString();
    }
}
