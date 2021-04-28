package OldExams2016.Dynamic;

/**
 * 有一个直方图，用一个整数数组表示，其中每列的宽度为1，求所给直方图包含的最大矩形面积。
 * 比如，对于直方图[2,7,9,4],它所包含的最大矩形的面积为14(即[7,9]包涵的7x2的矩形)。
 * 给定一个直方图A及它的总宽度n，请返回最大矩形面积。保证直方图宽度小于等于500。保证结果在int范围内。
 */
public class MaxInnerRec {
    public int countArea(int[] A, int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            int minValue = A[i];
            for (int j = i; j < n; j++) {
                minValue = Math.min(minValue, A[j]);
                result = Math.max(result, minValue * (j - i + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxInnerRec maxInnerRec = new MaxInnerRec();
        int result = maxInnerRec.countArea(new int[]{2, 7, 9, 4, 1}, 5);
        System.out.println(result);
    }
}
