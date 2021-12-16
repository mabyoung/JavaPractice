package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

public class FindLHS {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int nextKey = entry.getKey() + 1;
            Integer nextValue = map.get(nextKey);
            if (nextValue != null) {
                result = Math.max(result, nextValue + entry.getValue());
            }
        }
        return result;
    }
}
