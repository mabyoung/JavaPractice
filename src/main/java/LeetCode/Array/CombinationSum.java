package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    public void dfs(int[] candidate, int target, int index, List<List<Integer>> result, List<Integer> current) {
        if (target < 0 || index >= candidate.length) {
            return;
        }
        if (target == 0) {
            List<Integer> tmp = new ArrayList<>(current);
            result.add(tmp);
            return;
        }
        current.add(candidate[index]);
        dfs(candidate, target - candidate[index], index, result, current);
        current.remove(new Integer(candidate[index]));
        dfs(candidate, target, index + 1, result, current);
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> result = combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(result);
    }
}
