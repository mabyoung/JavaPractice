package LeetCode.Array;

import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        set.add(nums[i] + "_" + nums[j] + "_" + nums[left] + "_" + nums[right]);
                        left++;
                        right--;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (String str : set) {
            List<Integer> list = new ArrayList<>();
            for (String item : str.split("_")) {
                list.add(Integer.valueOf(item));
            }
            result.add(list);
        }
        return result;
    }
}
