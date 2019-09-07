package LeetCode.Array;

/**
 * 给定一个整数n，将数字1到n^2按螺旋的顺序填入n×n的矩阵
 * 例如：
 * 给出的n=3，
 * 你应该返回如下矩阵：
 * [↵ [ 1, 2, 3 ],↵ [ 8, 9, 4 ],↵ [ 7, 6, 5 ]↵]
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        int index = 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int j = colBegin; j <= colEnd; j++) {
                result[rowBegin][j] = index++;
            }
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; i++) {
                result[i][colEnd] = index++;
            }
            colEnd--;
            if (rowBegin <= rowEnd && colBegin <= colEnd) {
                for (int j = colEnd; j >= colBegin; j--) {
                    result[rowEnd][j] = index++;
                }
            }
            rowEnd--;
            if (rowBegin <= rowEnd && colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    result[i][colBegin] = index++;
                }
            }
            colBegin++;
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        int[][] result = spiralMatrixII.generateMatrix(1);
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
}
