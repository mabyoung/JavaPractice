package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                int index = getIndexOfLessThanTarget(list, nums[i]);
                list.set(index + 1, nums[i]);
            }
        }
        return list.size();
    }

    public int getIndexOfLessThanTarget(List<Integer> list, Integer target) {
        if (list.get(0) >= target) {
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
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        int result = lengthOfLIS.lengthOfLIS(new int[]{7,7,7});
        System.out.println(result);
    }
}
