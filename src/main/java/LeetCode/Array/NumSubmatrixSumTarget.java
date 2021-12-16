package LeetCode.Array;

/**
 * 1074. 元素和为目标值的子矩阵数量
 * 给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。
 * 子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。
 * 如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同。
 * 链接：https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target
 */
public class NumSubmatrixSumTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];
        int result = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
                result += getNumOfSumTarget(sum, i - 1, j - 1, target);
            }
        }
        return result;
    }

    public int getNumOfSumTarget(int[][] sum,  int x, int y, int target) {
        int result = 0;
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                int sumTmp = sum[x + 1][y + 1] - sum[x + 1][j] - sum[i][y + 1] + sum[i][j];
                if (sumTmp == target) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        int target = 0;
        NumSubmatrixSumTarget numSubmatrixSumTarget = new NumSubmatrixSumTarget();
        System.out.println(numSubmatrixSumTarget.numSubmatrixSumTarget(matrix, target));
    }
}
