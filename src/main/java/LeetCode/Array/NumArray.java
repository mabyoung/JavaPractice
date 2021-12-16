package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class NumArray {
    List<Integer> sumList;

    public NumArray(int[] nums) {
        sumList = new ArrayList<>();
        sumList.add(0);
        for (int i = 0; i < nums.length; i++) {
            sumList.add(i + 1, sumList.get(i) + nums[i]);
        }
    }

    public int sumRange(int left, int right) {
        return sumList.get(right + 1) - sumList.get(left);
    }
}
