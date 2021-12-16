package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

public class FindMaxLength {
    public int findMaxLength(int[] nums) {
        int result = 0;
        int[] sums = new int[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
            sums[i + 1] = sums[i] + nums[i];
            Integer value = map.get(sums[i + 1]);
            if (value == null) {
                map.put(sums[i + 1], i);
            } else {
                result = Math.max(result, i - value);
            }
        }
        return result;
    }
}
