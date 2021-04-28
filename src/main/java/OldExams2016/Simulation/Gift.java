package OldExams2016.Simulation;

import java.util.HashMap;
import java.util.Map;

public class Gift {
    public int getValue(int[] gifts, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int gift : gifts) {
            if (map.containsKey(gift)) {
                map.put(gift, map.get(gift) + 1);
            } else {
                map.put(gift, 1);
            }
            if (map.get(gift) > n / 2) {
                return gift;
            }
        }
        return 0;
    }
}
