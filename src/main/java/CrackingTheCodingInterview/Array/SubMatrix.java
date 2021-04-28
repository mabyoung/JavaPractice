package CrackingTheCodingInterview.Array;

/**
 * 有一个方阵，其中每个单元(像素)非黑即白(非0即1)，请设计一个高效算法，找到四条边颜色相同的最大子方阵。
 * 给定一个01方阵mat，同时给定方阵的边长n，请返回最大子方阵的边长。保证方阵边长小于等于100。
 *
 * 思路：定义left[i][j]: 表示坐标[i,j]的左边有连续相同的数个数，包含自己
 *      定义above[i][j]: 表示坐标[i,j]的上边有连续相同的数个数，包含自己
 *      一个以i，j为右下角，边长为w的方阵定义为left[i][j]>w && above[i][j]>w && left[i-w][j]>w && right[i][j-w]>w
 */
public class SubMatrix {
    public int maxSubMatrix(int[][] mat, int n) {
        int result = 1;
        int[][] left = new int[n][n];
        int[][] above = new int[n][n];
        init(mat, n, left, above);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int maxPossibleSideLength = Math.min(left[i][j], above[i][j]);
                for (int k = 1; k < maxPossibleSideLength; k++) {
                    int possibleSideLength = Math.min(Math.min(k + 1, left[i - k][j]), above[i][j - k]);
                    result = Math.max(result, possibleSideLength);
                }
            }
        }
        return result;
    }

    private void init(int[][] mat, int n, int[][] left, int[][] above) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    above[i][j] = 1;
                } else {
                    above[i][j] = (mat[i][j] == mat[i - 1][j]) ? above[i - 1][j] + 1 : 1;
                }
                if (j == 0) {
                    left[i][j] = 1;
                } else {
                    left[i][j] = (mat[i][j] == mat[i][j - 1]) ? left[i][j - 1] + 1 : 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        SubMatrix subMatrix = new SubMatrix();
        int[][] mat = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(subMatrix.maxSubMatrix(mat, 3));
    }
}
