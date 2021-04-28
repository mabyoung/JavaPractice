package LeetCode.Dynamic;

import java.util.Scanner;

public class MatrixElementMultiply {
    public static long getMaxMultipliedValue(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        long maxProduct = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                maxProduct = Math.max(maxProduct, getMultipliedValue(matrix, i, j));
            }
        }
        return maxProduct;
    }

    private static long getMultipliedValue(int[][] matrix, int i, int j) {
        long product = 1;
        for (int row = 0; row < matrix.length; row++) {
            if (row != i) {
                product *= matrix[row][j];
            }
        }
        for (int column = 0; column < matrix[0].length; column++) {
            if (column != j) {
                product *= matrix[i][column];
            }
        }
        return product;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            System.out.println(getMaxMultipliedValue(matrix));
        }
    }
}
