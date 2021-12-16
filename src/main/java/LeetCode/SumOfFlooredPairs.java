package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class SumOfFlooredPairs {
    public int sumOfFlooredPairs(int[] nums) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null){
                result += map.get(nums[i]);
                result = result % (1000000007);
                continue;
            }
            int total = 0;
            for (int j = 0; j < nums.length; j++) {
                total += nums[i] / nums[j];
                total = total % (1000000007);
            }
            result += total;
            result = result % (1000000007);
            map.put(nums[i], total);
        }
        return result;
    }

    public static void main(String[] args) {
        SumOfFlooredPairs sumOfFlooredPairs = new SumOfFlooredPairs();
        int[] nums = new int[]{7,7,7,7,7,7,7};
        System.out.println(sumOfFlooredPairs.sumOfFlooredPairs(nums));
    }
}
