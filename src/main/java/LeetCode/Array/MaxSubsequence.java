package LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSubsequence {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
        Arrays.sort(copy);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(copy[nums.length - 1 - i]);
        }
        int[] result = new int[k];
        int index = 0;
        for (int num : nums) {
            if (list.contains(num)){
                result[index++] = num;
                list.remove((Integer)num);
            }
        }
        return result;
    }
}
