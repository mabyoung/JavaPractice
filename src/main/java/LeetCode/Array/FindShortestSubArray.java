package LeetCode.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindShortestSubArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int maxValue = 0;
        for (Integer value : map.values()) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        List<Integer> targetNumList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValue){
                targetNumList.add(entry.getKey());
            }
        }
        int result = Integer.MAX_VALUE;
        for (Integer targetNum : targetNumList) {
            result = Math.min(result, findShortestSubArray(nums, targetNum));
        }
        return result;
    }

    public int findShortestSubArray(int[] nums, int targetNum) {
        int begin = 0;
        int end = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == targetNum) {
                begin = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == targetNum) {
                end = i;
                break;
            }
        }
        return end - begin + 1;
    }
}
