package LeetCode.Division;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给出一组数字，返回该组数字的所有排列
 * 例如：
 * [1,2,3]的所有排列如下
 * [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2], [3,2,1].
 */
public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(getList(num));
        int[] next = getNext(num);
        while (!isSame(num, next)) {
            result.add(getList(next));
            next = getNext(next);
        }
        return result;
    }

    private ArrayList<Integer> getList(int[] num) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int item : num) {
            result.add(item);
        }
        return result;
    }

    private boolean isSame(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] getNext(int[] num) {
        int[] result = Arrays.copyOf(num, num.length);
        int i = num.length - 1;
        while (i > 0 && num[i] <= num[i - 1]) {
            i--;
        }
        if (i == 0) {
            return reverse(result, 0, result.length - 1);
        }
        int j = i + 1;
        while (j < num.length && num[j] > num[i - 1]) {
            j++;
        }
        if (j > num.length) {
            int tmp = num[i - 1];
            result[i - 1] = result[i];
            result[i] = tmp;
        } else {
            int tmp = num[i - 1];
            result[i - 1] = result[j - 1];
            result[j - 1] = tmp;
        }
        return reverse(result, i, result.length - 1);
    }

    private int[] reverse(int[] num, int begin, int end) {
        for (int i = begin, j = end; i < j; i++, j--) {
            int tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
        }
        return num;
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        ArrayList<ArrayList<Integer>> result = permutations.permute(new int[]{1, 2, 3, 4, 5, 6, 7});
        for (ArrayList<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
