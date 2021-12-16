package LeetCode.Array;

import java.util.*;

public class MinDifference {
    public int[] minDifference(int[] nums, int[][] queries) {
        int[][] dp = new int[nums.length][nums.length];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        Set<Integer>[][] set = new Set[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                set[i][j] = new HashSet<>();
                if (j>i){
                    set[i][j].addAll(set[i][j-1]);
                }
                set[i][j].add(nums[j]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = dp[i][j - 1];
                for (int index = 1; index < 100; index++) {
                    if (set[i][j].contains(nums[j]-index) || set[i][j].contains(nums[j]+index)){
                        dp[i][j] = Math.min(index, dp[i][j]);
                        break;
                    }
                }
            }
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = dp[queries[i][0]][queries[i][1]];
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinDifference minDifference = new MinDifference();
        int[] nums = new int[]{4,5,2,2,7,10};
        int[][] queries = new int[][]{{2,3},{0,2},{0,5},{3,5}};
        int[] result = minDifference.minDifference(nums, queries);
        for (int item : result) {
            System.out.println(item);
        }
    }
}
