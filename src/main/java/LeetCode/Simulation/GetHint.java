package LeetCode.Simulation;

import java.util.HashMap;
import java.util.Map;

public class GetHint {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int bullCount = 0;
        int cowCount = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char a = secret.charAt(i);
            char b = guess.charAt(i);
            if (a == b) {
                bullCount++;
            } else {
                map1.merge(a, 1, Integer::sum);
                map2.merge(b, 1, Integer::sum);
            }
        }
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            int value1 = entry.getValue();
            Integer value2 = map2.get(entry.getKey());
            if (value2 != null) {
                cowCount += Math.min(value1, value2);
            }
        }
        return bullCount + "A" + cowCount + "B";
    }
}
