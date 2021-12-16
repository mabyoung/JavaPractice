package LeetCode.Num;

import java.util.HashSet;
import java.util.Set;

public class MinAbsoluteSumDiff {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
            result = (result + Math.abs(nums1[i] - nums2[i])) % 1000000007;
        }
        int maxAbs = 0;
        for (int i = 0; i < nums1.length; i++) {
            int abs = Math.abs(nums2[i] - nums1[i]);
            for (int j = 0; j < abs && j < abs - maxAbs; j++) {
                if (set.contains(nums2[i] - j) || set.contains(nums2[i] + j)) {
                    maxAbs = Math.max(maxAbs, abs - j);
                    break;
                }
            }
        }
        if (result < maxAbs) {
            result += 1000000007;
        }
        return result - maxAbs;
    }
}
