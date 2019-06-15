package LeetCode.Array;

import java.util.ArrayList;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for (int j = 1; j < i; j++) {
                tmp.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            if (i > 0) {
                tmp.add(1);
            }
            result.add(tmp);
        }
        return result;
    }

    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        ArrayList<ArrayList<Integer>> generate = pascalsTriangle.generate(5);
        System.out.println(generate);
    }
}
