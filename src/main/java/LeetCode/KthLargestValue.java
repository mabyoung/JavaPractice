package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1738. 找出第 K 大的异或坐标值
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 * 链接：https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value
 */
public class KthLargestValue {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] tmp = new int[n];
        int[][] xor = new int[m][n];
        xor[0][0] = matrix[0][0];
        for (int j = 1; j < n; j++) {
            xor[0][j] = xor[0][j - 1] ^ matrix[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    xor[i][j] = xor[i - 1][j] ^ matrix[i][j];
                    tmp[j] = matrix[i][j];
                } else {
                    tmp[j] = tmp[j - 1] ^ matrix[i][j];
                    xor[i][j] = xor[i - 1][j] ^ tmp[j];
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.add(xor[i][j]);
            }
        }
        nthElement(list, 0, k - 1, list.size() - 1);
        return list.get(k - 1);
    }

    public void nthElement(List<Integer> results, int left, int kth, int right) {
        if (left == right) {
            return;
        }
        int pivot = (int) (left + Math.random() * (right - left + 1));
        swap(results, pivot, right);
        // 三路划分（three-way partition）
        int sepl = left - 1, sepr = left - 1;
        for (int i = left; i <= right; i++) {
            if (results.get(i) > results.get(right)) {
                swap(results, ++sepr, i);
                swap(results, ++sepl, sepr);
            } else if (results.get(i) == results.get(right)) {
                swap(results, ++sepr, i);
            }
        }
        if (sepl < left + kth && left + kth <= sepr) {
            return;
        } else if (left + kth <= sepl) {
            nthElement(results, left, kth, sepl);
        } else {
            nthElement(results, sepr + 1, kth - (sepr - left + 1), right);
        }
    }

    public void swap(List<Integer> results, int index1, int index2) {
        int temp = results.get(index1);
        results.set(index1, results.get(index2));
        results.set(index2, temp);
    }

    public static void main(String[] args) {
        KthLargestValue kthLargestValue = new KthLargestValue();
        int[][] matrix = new int[][]{{5, 2}, {1, 6}};
        int result = kthLargestValue.kthLargestValue(matrix, 4);
        System.out.println(result);
    }
}
