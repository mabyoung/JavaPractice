package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums) {
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                evenList.add(num);
            } else {
                oddList.add(num);
            }
        }
        int[] result = new int[nums.length];
        int oddIndex = 0;
        int evenIndex = 0;
        for (int i = 0; i < result.length; i++) {
            if (i % 2 == 0) {
                result[i] = evenList.get(evenIndex++);
            } else {
                result[i] = oddList.get(oddIndex++);
            }
        }
        return result;
    }
}
