package LeetCode.Array;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove((Integer)num);
            } else {
                set.add(num);
            }
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (Integer item : set) {
            result[index++] = item;
        }
        return result;
    }
}
