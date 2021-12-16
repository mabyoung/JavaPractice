package LeetCode.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long result = 0;
        List<Integer> list = new ArrayList<>();
        int countZero = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    countZero++;
                } else if (matrix[i][j] > 0) {
                    result += matrix[i][j];
                    min = Math.min(min, matrix[i][j]);
                } else {
                    list.add(-matrix[i][j]);
                    min = Math.min(min, -matrix[i][j]);
                }
            }
        }
        Collections.sort(list);
        long listSum = 0;
        for (Integer item : list) {
            listSum += item;
        }
        if (countZero > 0 || list.size() % 2 == 0) {
            return result + listSum;
        } else {
            return result + listSum - 2 * min;
        }
    }

    public static void main(String[] args) {
        MaxMatrixSum maxMatrixSum = new MaxMatrixSum();
        maxMatrixSum.maxMatrixSum(new int[][]{{1, 2, 3}, {-1, -2, -3}, {1, 2, 3}});
    }
}
