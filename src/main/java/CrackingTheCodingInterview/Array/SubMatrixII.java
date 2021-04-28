package CrackingTheCodingInterview.Array;

public class SubMatrixII {
    public int sumOfSubMatrix(int[][] mat, int n) {
        int result = 0;
        for (int i = 0; i < mat.length; i++) {
            int[] subMat = new int[mat.length];
            for (int j = i; j < mat.length; j++) {
                for (int k = 0; k < mat[0].length; k++) {
                    subMat[k] += mat[j][k];
                }
                result = Math.max(result, maxSumOfSubMatrix(subMat));
            }
        }
        return result;
    }

    private int maxSumOfSubMatrix(int[] mat) {
        int maxSum = mat[0];
        int currentSum = 0;
        for (int item : mat) {
            currentSum += item;
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        SubMatrixII subMatrixII = new SubMatrixII();
        int result = subMatrixII.sumOfSubMatrix(new int[][]{{1, 2, -3}, {3, 4, -5}, {-5, -6, -7}}, 3);
        System.out.println(result);
    }
}
