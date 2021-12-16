package LeetCode.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> rest = new ArrayList<>();
        for (int num : nums) {
            rest.add(num);
        }
        Collections.sort(rest);
        dfs(rest, new ArrayList<>(), result);
        return result;
    }

    public void dfs(List<Integer> rest, List<Integer> current, List<List<Integer>> result) {
        if (rest.isEmpty()){
            result.add(current);
            return;
        }
        for (int i = 0; i < rest.size(); i++) {
            if (i == 0 || !rest.get(i).equals(rest.get(i - 1))){
                List<Integer> newRest = new ArrayList<>(rest);
                newRest.remove(i);
                List<Integer> newCurrent = new ArrayList<>(current);
                newCurrent.add(rest.get(i));
                dfs(newRest, newCurrent, result);
            }
        }
    }

}
