package LeetCode.Array;

import java.util.ArrayList;

public class SpiralMatrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            result.add(matrix[0][i]);
        }
        return result;
    }
}
