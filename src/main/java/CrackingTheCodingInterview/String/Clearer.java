package CrackingTheCodingInterview.String;

public class Clearer {
    public int[][] clearZero(int[][] mat, int n) {
        boolean isColZero = false;
        boolean isRowZero = false;
        for (int i = 0; i < n; i++) {
            if (mat[i][0] == 0) {
                isColZero = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (mat[0][j] == 0) {
                isRowZero = true;
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }
        if (isColZero) {
            for (int i = 0; i < n; i++) {
                mat[i][0] = 0;
            }
        }
        if (isRowZero) {
            for (int j = 0; j < n; j++) {
                mat[0][j] = 0;
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        Clearer clearer = new Clearer();
        int[][] result = clearer.clearZero(new int[][]{{1, 2, 3}, {4, 5, 6}, {0, 7, 8}}, 3);
        System.out.println(result);
    }
}