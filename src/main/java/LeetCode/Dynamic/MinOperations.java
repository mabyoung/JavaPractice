package LeetCode.Dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinOperations {
    public int minOperations(int[] target, int[] arr) {
        int m = target.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(target[i], i);
        }
        List<Integer> newArr = new ArrayList<>();
        for (int value : arr) {
            if (map.containsKey(value)) {
                newArr.add(map.get(value));
            }
        }
        int longestIncreaseSubsequence = getLongestIncreaseSubsequence(newArr);
        return m - longestIncreaseSubsequence;
    }

    public int getLongestIncreaseSubsequence(List<Integer> newArr) {
        if (newArr == null || newArr.isEmpty()) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        list.add(newArr.get(0));
        for (int i = 1; i < newArr.size(); i++) {
            if (newArr.get(i) > list.get(list.size() - 1)) {
                list.add(newArr.get(i));
            } else {
                int index = findIndexOfLessThanTarget(list, newArr.get(i));
                list.set(index + 1, newArr.get(i));
            }
        }
        return list.size();
    }

    public int findIndexOfLessThanTarget(List<Integer> list, int target) {
        if (target <= list.get(0)) {
            return -1;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (list.get(mid) >= target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        MinOperations minOperations = new MinOperations();
        int result = minOperations.minOperations(new int[]{1, 3, 8}, new int[]{2, 6});
        System.out.println(result);
    }
}
