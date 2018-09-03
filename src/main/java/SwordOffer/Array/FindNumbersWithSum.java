package SwordOffer.Array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S。
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 思路：
 * 链接：https://www.nowcoder.com/questionTerminal/390da4f7a00f44bea7c2f3d19491311b
 * 若ai + aj == sum，就是答案（相差越远乘积越小）
 * 若ai + aj > sum，aj肯定不是答案之一（前面已得出 i 前面的数已是不可能），j -= 1
 * 若ai + aj < sum，ai肯定不是答案之一（前面已得出 j 后面的数已是不可能），i += 1
 */
public class FindNumbersWithSum {
    public static ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i : array) {
            map.put(i, 1);
        }
        int product = Integer.MAX_VALUE;
        for (int i : array) {
            if (map.containsKey(sum - i)) {
                if (i * (sum - i) < product) {
                    product = i * (sum - i);
                    if (result.size() == 0) {
                        result.add(0, Math.min(i, sum - i));
                        result.add(1, Math.max(i, sum - i));
                    } else {
                        result.set(0, Math.min(i, sum - i));
                        result.set(1, Math.max(i, sum - i));
                    }
                }
            }
        }
        return result;
    }

    public static ArrayList<Integer> findNumbersWithSum2(int[] array, int sum) {
        int i = 0, j = array.length - 1;
        ArrayList<Integer> result = new ArrayList<>();
        while (i < j) {
            if (array[i] + array[j] == sum) {
                result.add(array[i]);
                result.add(array[j]);
                return result;
            } else if (array[i] + array[j] > sum) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int array[] = {1, 3, 4, 5, 6, 9};
        ArrayList<Integer> list = findNumbersWithSum2(array, 9);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
