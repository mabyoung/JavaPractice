package LeetCode.Simulation;

public class MatrixReshape {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] result = new int[r][c];
        int i = 0;
        int j = 0;
        for (int[] ints : mat) {
            for (int item : ints) {
                result[i][j] = item;
                if (++j >= c) {
                    i++;
                    j = 0;
                }
            }
        }
        return result;
    }
}
