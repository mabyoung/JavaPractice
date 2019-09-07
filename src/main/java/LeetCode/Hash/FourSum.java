package LeetCode.Hash;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给出一个有n个元素的数组S，S中是否有元素a,b,c和d满足a+b+c+d=目标值？找出数组S中所有满足条件的四元组。
 * 注意：
 * 四元组（a、b、c、d）中的元素必须按非降序排列。（即a≤b≤c≤d）
 * 解集中不能包含重复的四元组。
 * 例如：给出的数组 S = {1 0 -1 0 -2 2}, 目标值 = 0.↵↵    给出的解集应该是：↵    (-1,  0, 0, 1)↵    (-2, -1, 1, 2)↵    (-2,  0, 0, 2)
 */
public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < num.length - 2; j++) {
                if (j > i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = num.length - 1;
                while (k < l) {
                    if (k > j + 1 && num[k] == num[k - 1]) {
                        k++;
                        continue;
                    } else if (l < num.length - 1 && num[l] == num[l + 1]) {
                        l--;
                        continue;
                    }
                    int sum = num[i] + num[j] + num[k] + num[l];
                    if (sum == target) {
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(num[k]);
                        tmp.add(num[l]);
                        result.add(tmp);
                        k++;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        ArrayList<ArrayList<Integer>> result = fourSum.fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0);
        for (ArrayList<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
