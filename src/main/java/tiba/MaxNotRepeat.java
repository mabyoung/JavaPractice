package tiba;

import jxl.common.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
 * 输入 [2,3,4,5] 输出 4
 * 输入 [2,2,3,4,3] 输出 3
 */
public class MaxNotRepeat {
    /**
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int max = 0;
        for (int value : arr) {
            while (set.contains(value)) {
                set.remove(arr[left++]);
            }
            set.add(value);
            max = Math.max(max, set.size());
        }
        return max;
    }

    public static void main(String[] args) {
        MaxNotRepeat maxNotRepeat = new MaxNotRepeat();
        System.out.println(maxNotRepeat.maxLength(new int[]{2, 3, 4, 5}));
        System.out.println(maxNotRepeat.maxLength(new int[]{2, 2, 3, 4, 3}));
    }
}
