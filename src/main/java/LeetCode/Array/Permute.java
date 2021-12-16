package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(numList, result, new ArrayList<>());
        return result;
    }

    public void dfs(List<Integer> numList, List<List<Integer>> result, List<Integer> current) {
        if (numList.isEmpty()) {
            result.add(current);
        } else {
            for (int i = 0; i < numList.size(); i++) {
                List<Integer> newCurrent = new ArrayList<>(current);
                newCurrent.add(numList.get(i));
                List<Integer> newNumList = new ArrayList<>(numList);
                newNumList.remove(i);
                dfs(newNumList, result, newCurrent);
            }
        }
    }
}
