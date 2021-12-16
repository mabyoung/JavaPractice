package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 链接：https://leetcode-cn.com/problems/two-sum
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            Integer index = map.get(target - numbers[i]);
            if (index != null) {
                return new int[]{index + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(twoSum.twoSum(new int[]{2, 7, 11, 15}, 9));
    }
}
