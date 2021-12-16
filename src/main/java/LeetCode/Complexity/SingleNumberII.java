package LeetCode.Complexity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 137. 只出现一次的数字 II
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class SingleNumberII {
    public int singleNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : A) {
            map.merge(item, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {1};
        SingleNumberII singleNumberII = new SingleNumberII();
        System.out.println(singleNumberII.singleNumber(A));
    }
}
