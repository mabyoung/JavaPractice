package LeetCode.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonFromSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (String word : s1.split(" ")) {
            map1.merge(word, 1, Integer::sum);
        }
        for (String word : s2.split(" ")) {
            map2.merge(word, 1, Integer::sum);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (entry.getValue() == 1 && !map2.containsKey(entry.getKey())) {
                list.add(entry.getKey());
            }
        }
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            if (entry.getValue() == 1 && !map1.containsKey(entry.getKey())) {
                list.add(entry.getKey());
            }
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
