package LeetCode.Array;


import java.util.*;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    public void dfs(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> list) {
        if (target == 0) {
            result.add(list);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }
            if (set.contains(candidates[i])) {
                continue;
            }
            set.add(candidates[i]);
            List<Integer> newList = new ArrayList<>(list);
            newList.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, result, newList);
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        combinationSum2.combinationSum2(new int[]{14, 6, 25, 9, 30, 20, 33, 34, 28, 30, 16, 12, 31, 9, 9, 12, 34, 16, 25, 32, 8, 7, 30, 12, 33, 20, 21, 29, 24, 17, 27, 34, 11, 17, 30, 6, 32, 21, 27, 17, 16, 8, 24, 12, 12, 28, 11, 33, 10, 32, 22, 13, 34, 18, 12}, 27);
    }
}
