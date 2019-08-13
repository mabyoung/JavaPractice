package LeetCode.Search;

import java.util.*;

/**
 * Given a collection of candidate numbers ( C ) and a target number ( T ), find all unique combinations in C where the candidate numbers sums to T .
 *
 * Each number in C may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a 1, a 2, … , a k) must be in non-descending order. (ie, a 1 ≤ a 2 ≤ … ≤ a k).
 * The solution set must not contain duplicate combinations.
 *
 * For example, given candidate set10,1,2,7,6,1,5and target8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 */
public class CombinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Set<ArrayList<Integer>> result = new LinkedHashSet<>();
        ArrayList<Integer> current = new ArrayList<>();
        Arrays.sort(num);
        dfs(result, current, num, 0, target);
        return new ArrayList<>(result);
    }

    public void dfs(Set<ArrayList<Integer>> result, ArrayList<Integer> current, int[] num, int index, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
        } else if (target > 0) {
            for (int i = index; i < num.length; i++) {
                current.add(num[i]);
                dfs(result, current, num, i + 1, target - num[i]);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        ArrayList<ArrayList<Integer>> result = combinationSumII.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println(result);
    }
}
