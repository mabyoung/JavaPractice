package CrackingTheCodingInterview.Search;

public class MatrixFinder {
    public int[] findElement(int[][] mat, int n, int m, int x) {
        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {
            if (mat[i][j] == x) {
                return new int[]{i, j};
            } else if (mat[i][j] < x) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MatrixFinder matrixFinder = new MatrixFinder();
        int[] result = matrixFinder.findElement(new int[][]{{1, 2, 3}, {4, 5, 6}}, 2, 3, 6);
        System.out.println(result);
    }
}
