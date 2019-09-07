package LeetCode.Hash;

import java.util.*;

/**
 * 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
 * 注意：
 * 三元组（a、b、c、d）中的元素必须按非降序排列。（即a≤b≤c）
 * 解集中不能包含重复的四元组。
 * 例如，给定的数组 S = {-1 0 1 2 -1 -4},↵↵    解集为：↵    (-1, 0, 1)↵    (-1, -1, 2)
 */
public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(num);
        for (int i = 0; i <= num.length - 3; i++) {
            if (num[i] > 0) {
                break;
            }
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            for (int j = i + 1, k = num.length - 1; j < k; j++, k--) {
                if (j > i + 1 && num[j] == num[j - 1] && k < num.length - 1 && num[k] == num[k + 1]) {
                    continue;
                }
                int sum = num[i] + num[j] + num[k];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num[i]);
                    list.add(num[j]);
                    list.add(num[k]);
                    result.add(list);
                } else if (sum > 0) {
                    j--;
                } else {
                    k++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        ArrayList<ArrayList<Integer>> result = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        result = threeSum.threeSum(new int[]{-2, 0, 0, 2, 2});
        for (ArrayList<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
