package LeetCode.Array;

import java.util.Arrays;

public class FindGCD {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];
        return gcd(min, max);
    }

    public int gcd(int x, int y) {
        while (x != 0 && y != 0) {
            y = y % x;
            if (y != 0) {
                x = x % y;
            }
        }
        return x != 0 ? Math.abs(x) : Math.abs(y);
    }
}
