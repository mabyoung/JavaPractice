package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.isEmpty() || num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int index = getIndex(list, num);
                if (index >= 0) {
                    list.set(index + 1, num);
                }
            }
        }
        return nums.length + 1 - list.size();
    }

    public int getIndex(List<Integer> list, int num) {
        if (num <= list.get(0)) {
            return -1;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (list.get(mid) >= num) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
