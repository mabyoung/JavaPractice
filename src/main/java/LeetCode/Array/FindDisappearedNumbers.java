package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] flag = new boolean[nums.length + 1];
        for (int num : nums) {
            flag[num] = true;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < flag.length; i++) {
            if (!flag[i]) {
                list.add(i);
            }
        }
        return list;
    }
}
