package LeetCode.Array;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Integer index = map.get(-nums[i] - nums[j]);
                if (index == null) {
                    continue;
                }
                int min = getMin(nums[i], nums[j], -nums[i] - nums[j]);
                int max = getMax(nums[i], nums[j], -nums[i] - nums[j]);
                String key = min + "_" + max;
                if (index > j && !set.contains(key)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(-nums[i] - nums[j]);
                    result.add(list);
                    set.add(key);
                }
            }
        }
        return result;
    }

    public int getMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public int getMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

}
