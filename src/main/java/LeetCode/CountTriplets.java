package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1442. 形成两个异或相等数组的三元组数目
 * 给你一个整数数组 arr 。
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 * a 和 b 定义如下：
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 * 链接：https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor
 */
public class CountTriplets {
    public int countTriplets(int[] arr) {
        int result = 0;
        int n = arr.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] ^ arr[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s[i] == s[j + 1]) {
                    result += (j - i);
                }
            }
        }
        return result;
    }

    public int countTriplets1(int[] arr) {
        int result = 0;
        int n = arr.length;
        int[][] xor = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                xor[i][j] = i == j ? arr[i] : xor[i][j - 1] ^ arr[j];
            }
        }
        for (int i = 1; i < n; i++) {
            result += getSameXor(xor, i);
        }
        return result;
    }

    public int getSameXor(int[][] xor, int divide) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < divide; i++) {
            int key = xor[i][divide - 1];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        for (int j = divide; j < xor.length; j++) {
            int key = xor[divide][j];
            if (map.containsKey(key)) {
                result += map.get(key);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountTriplets countTriplets = new CountTriplets();
        int arr[] = new int[]{1, 1, 1, 1, 1};
        System.out.println(countTriplets.countTriplets(arr));
    }
}
