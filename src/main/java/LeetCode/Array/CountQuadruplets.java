package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

public class CountQuadruplets {
    public int countQuadruplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k+1; l < n; l++) {
                        if (nums[i]+nums[j]+nums[k] == nums[l]){
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountQuadruplets countQuadruplets = new CountQuadruplets();
        countQuadruplets.countQuadruplets(new int[]{28,8,49,85,37,90,20,8});
    }
}
