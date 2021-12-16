package LeetCode.Simulation;

import java.util.HashMap;
import java.util.Map;

public class MinimumSwitchingTimes {
    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        int m = source.length;
        int n = source[0].length;
        Map<Integer, Integer> sourceMap = new HashMap<>();
        Map<Integer, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sourceMap.merge(source[i][j], 1, Integer::sum);
                targetMap.merge(target[i][j], 1, Integer::sum);
            }
        }
        int result = 0;
        for (Integer key : sourceMap.keySet()) {
            Integer sourceValue = sourceMap.get(key);
            Integer targetValue = targetMap.get(key);
            if (targetValue == null) {
                targetValue = 0;
            }
            result += Math.max(0, sourceValue - targetValue);
        }
        return result;
    }
}
