package SwordOffer.Array;

import java.util.ArrayList;

public class PrintMatrix {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        int col = matrix.length;
        int row = matrix[0].length;
        int circle = ((row < col ? row : col) - 1) / 2 + 1;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < circle; i++) {
            for (int j = i; j < row - i; j++) {
                result.add(matrix[i][j]);
            }
            for (int j = i + 1; j < row - i; j++) {
                result.add(matrix[j][col - 1 - i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 17}, {5, 6, 7, 8, 18}, {9, 10, 11, 12, 19}, {13, 14, 15, 16, 20}, {21, 22, 23, 24, 25}};
        ArrayList<Integer> integers = printMatrix(matrix);
        for (Integer integer : integers) {
            System.out.println(integer + " ");
        }
    }
}
