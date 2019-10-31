package LeetCode.Dynamic;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        dfs(result, current, S, 0);
        result.sort((o1, o2) -> {
            if (o1.size() != o2.size()) {
                return Integer.compare(o1.size(), o2.size());
            }
            for (int i = 0; i < o1.size(); i++) {
                int compare = Integer.compare(o1.get(i), o2.get(i));
                if (compare != 0) {
                    return compare;
                }
            }
            return 0;
        });
        return result;
    }

    private void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current, int[] s, int index) {
        result.add(new ArrayList<>(current));
        if (index >= s.length) {
            return;
        }
        for (int i = index; i < s.length; i++) {
            current.add(s[i]);
            dfs(result, current, s, i + 1);
            current.remove(current.size() - 1);
        }
    }


    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        ArrayList<ArrayList<Integer>> result = subsets.subsets(new int[]{4, 1, 0});
        for (ArrayList<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
