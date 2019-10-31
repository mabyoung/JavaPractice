package LeetCode.Dynamic;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给出一个可能包含重复元素的整数集合S，返回该整数集合的所有子集。
 * 注意：
 * 你给出的子集中的元素要按非递增的顺序排列
 * 给出的解集中不能包含重复的子集
 * 例如：
 * 如果S =[1,2,2], 给出的解集应该是：
 * [↵  [2],↵  [1],↵  [1,2,2],↵  [2,2],↵  [1,2],↵  []↵]
 */
public class SubsetsII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        dfs(result, current, num, 0);
        return new ArrayList<>(result);
    }

    public void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current, int[] num, int i) {
        result.add(new ArrayList<>(current));
        for (int j = i; j < num.length; j++) {
            if (j > i && num[j] == num[j - 1]) {
                continue;
            }
            current.add(num[j]);
            dfs(result, current, num, j + 1);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetsII subsetsII = new SubsetsII();
        ArrayList<ArrayList<Integer>> result = subsetsII.subsetsWithDup(new int[]{1, 2, 2});
        for (ArrayList<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
