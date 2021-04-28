package tiba;

public class MaxSquare {
    /**
     * 最大正方形
     *
     * @param matrix char字符型二维数组
     * @return int整型
     */
    public int solve(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int side = dp[i - 1][j - 1];
                if (side > 0) {
                    dp[i][j] = getMaxSquare(matrix, j - 1 - side, j - 1, i - 1 - side, i - 1);
                } else {
                    dp[i][j] = matrix[i - 1][j - 1] == '0' ? 0 : 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

    /**
     *获取给定范围的最大正方形边长
     */
    public int getMaxSquare(char[][] matrix, int left, int right, int top, int bottom) {
        int sideI = 0;
        int sideJ = 0;
        for (int i = bottom; i >= top; i--) {
            if (matrix[i][right] == '0') {
                break;
            }
            sideI++;
        }
        for (int j = right; j >= left; j--) {
            if (matrix[bottom][j] == '0') {
                break;
            }
            sideJ++;
        }
        return Math.min(sideI, sideJ);
    }

    public static void main(String[] args) {
        MaxSquare maxSquare = new MaxSquare();
        char[][] matrix = new char[][]{
                {'1', '0', '1', '1', '1', '1', '1', '0', '0', '0', '1', '0', '0', '0'},
                {'1', '0', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'1', '0', '1', '0', '1', '1', '1', '0', '0', '0', '1', '0', '0', '0'},
                {'1', '1', '0', '1', '1', '1', '1', '0', '1', '0', '1', '0', '1', '0'},
                {'1', '1', '1', '1', '1', '1', '1', '0', '0', '0', '1', '0', '0', '0'},
                {'1', '0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0'},
                {'1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0'},
                {'1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '0', '0'},
                {'1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '0', '0'},
                {'1', '0', '1', '1', '0', '1', '1', '0', '1', '0', '1', '1', '0', '0'},
                {'1', '0', '1', '1', '0', '1', '1', '0', '0', '0', '1', '1', '0', '0'}};
        int result = maxSquare.solve(matrix);
        System.out.println(result);
    }
}
