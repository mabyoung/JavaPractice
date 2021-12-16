package LeetCode;

public class CanEat {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] result = new boolean[queries.length];
        long[] sum = new long[candiesCount.length + 1];
        for (int i = 1; i <= candiesCount.length; i++) {
            sum[i] = sum[i - 1] + candiesCount[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            long min = queries[i][1] + 1;
            long max = min * queries[i][2];
            long targetBegin = sum[queries[i][0]] + 1;
            long targetEnd = sum[queries[i][0] + 1];
            if (!(min > targetEnd || max < targetBegin)) {
                result[i] = true;
            }
        }
        return result;
    }
}
