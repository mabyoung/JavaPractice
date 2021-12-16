package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 */
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int[] sum = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sum[0] = nums[0];
            } else {
                sum[i] = sum[i - 1] + nums[i];
            }
            Integer num = map.get(sum[i] - k);
            if (num != null) {
                result += num;
            }
            map.merge(sum[i], 1, Integer::sum);
        }
        return result;
    }

    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        int result = subarraySum.subarraySum(new int[]{1, 1, 1}, 2);
        System.out.println(result);
    }
}
