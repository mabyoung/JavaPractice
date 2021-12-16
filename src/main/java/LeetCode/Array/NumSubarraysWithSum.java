package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

public class NumSubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int result = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(sum, 1, Integer::sum);
            sum += num;
            result += map.getOrDefault(sum-goal, 0);
        }
        return result;
    }
}
