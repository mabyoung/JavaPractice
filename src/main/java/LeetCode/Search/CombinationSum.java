package LeetCode.Search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of candidate numbers ( C ) and a target number ( T ), find all unique combinations in C where the candidate numbers sums to T .
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a 1, a 2, … , a k) must be in non-descending order. (ie, a 1 ≤ a 2 ≤ … ≤ a k).
 * The solution set must not contain duplicate combinations.
 *
 * For example, given candidate set2,3,6,7and target7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 */
public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(result, current, 0, candidates, target);
        return result;
    }

    public void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current, int index, int[] candidates, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
        } else if (target > 0) {
            for (int i = index; i < candidates.length; i++) {
                current.add(candidates[i]);
                dfs(result, current, i, candidates, target-candidates[i]);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        ArrayList<ArrayList<Integer>> result = combinationSum.combinationSum(new int[]{8, 7, 4, 3}, 11);
        System.out.println(result);
    }
}