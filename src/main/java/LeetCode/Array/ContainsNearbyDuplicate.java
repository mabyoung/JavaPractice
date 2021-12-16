package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(nums[i]);
            if (value != null && i - value <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
