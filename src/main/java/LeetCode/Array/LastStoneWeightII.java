package LeetCode.Array;

import java.util.HashSet;
import java.util.Set;

public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        Set<Integer> set = new HashSet<>();
        for (int stone : stones) {
            if (set.isEmpty()){
                set.add(stone);
                continue;
            }
            Set<Integer> helper = new HashSet<>();
            for (Integer integer : set) {
                helper.add(Math.abs(integer-stone));
                helper.add(integer+stone);
            }
            set = helper;
        }
        int result = stones[0];
        for (Integer integer : set) {
            result = Math.min(result, integer);
        }
        return result;
    }

    public static void main(String[] args) {
        LastStoneWeightII lastStoneWeightII = new LastStoneWeightII();
        int result = lastStoneWeightII.lastStoneWeightII(new int[]{2,7,4,1,8,1});
        System.out.println(result);
    }
}
