package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

public class CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int lastValue = sum[1] % k;
        for (int i = 2; i < sum.length; i++) {
            int mod = sum[i] % k;
            if (mod == 0 || map.containsKey(mod)) {
                return true;
            }
            map.put(lastValue, 1);
            lastValue = mod;
        }
        return false;
    }

    public static void main(String[] args) {
        CheckSubarraySum checkSubarraySum = new CheckSubarraySum();
        boolean result = checkSubarraySum.checkSubarraySum(new int[]{1, 2, 1}, 5);
        System.out.println(result);
    }
}
