package LeetCode.Array;

import java.util.Arrays;

public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        int result = 0;
        while (index < nums.length) {
            result += nums[index];
            index += 2;
        }
        return result;
    }
}
