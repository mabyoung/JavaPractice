package LeetCode.Array;

import java.util.ArrayList;

/**
 * Given an index k, return the k th row of the Pascal's triangle.
 * For example, given k = 3,
 * Return[1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangleII {
    public ArrayList<Integer> getRow(int rowIndex){
        ArrayList<Integer> lastTurn = new ArrayList<>();
        ArrayList<Integer> thisTurn = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            thisTurn= new ArrayList<>();
            thisTurn.add(1);
            for (int j = 1; j < i; j++) {
                thisTurn.add(lastTurn.get(j - 1) + lastTurn.get(j));
            }
            if (i > 0) {
                thisTurn.add(1);
            }
            lastTurn = thisTurn;
        }
        return thisTurn;
    }

    public static void main(String[] args) {
        PascalsTriangleII pascalsTriangleII = new PascalsTriangleII();
        ArrayList<Integer> row = pascalsTriangleII.getRow(0);
        System.out.println(row);
    }
}
