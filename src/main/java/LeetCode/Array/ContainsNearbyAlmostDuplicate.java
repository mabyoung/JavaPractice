package LeetCode.Array;

import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 0 || k == 0) {
            return false;
        }
        TreeSet<Long> treeSet = new TreeSet<>();
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = treeSet.ceiling((long) nums[i]);
            if (ceiling != null && ceiling - nums[i] <= t) {
                return true;
            }
            Long floor = treeSet.floor((long) nums[i]);
            if (floor != null && nums[i] - floor <= t) {
                return true;
            }
            if (i - left >= k) {
                treeSet.remove((long) nums[left++]);
            }
            treeSet.add((long) nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyAlmostDuplicate containsNearbyAlmostDuplicate = new ContainsNearbyAlmostDuplicate();
        System.out.println(containsNearbyAlmostDuplicate.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }
}
