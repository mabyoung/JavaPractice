package LeetCode.Search;

import java.util.ArrayList;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * For example,
 * If n = 4 and k = 2, a solution is:
 *
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            dfs(result, current, n, k, i);
        }
        return result;
    }

    public void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current, int n, int k, int currentNum){
        if (currentNum > n){
            return;
        }
        current.add(currentNum);
        if (current.size() == k){
            result.add(new ArrayList<>(current));
        }
        for (int i = currentNum+1; i <= n; i++) {
            dfs(result, current, n, k, i);
        }
        current.remove(current.size()-1);
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        ArrayList<ArrayList<Integer>> result = combinations.combine(4, 2);
        System.out.println(result);
    }
}
