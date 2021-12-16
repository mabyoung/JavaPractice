package LeetCode.Simulation;

public class MinimizeTheDifference {
    private static int sum = 0;
    private static int result = Integer.MAX_VALUE;

    public int minimizeTheDifference(int[][] mat, int target) {
        sum = 0;
        result = Integer.MAX_VALUE;
        dfs(mat, target, 0);
        return result;
    }

    public void dfs(int[][] mat, int target, int curLevel) {
        int m = mat.length;
        int n = mat[0].length;
        if (curLevel >= m) {
            result = Math.min(result, Math.abs(sum - target));
        } else {
            for (int i = 0; i < n; i++) {
                sum += mat[curLevel][i];
                dfs(mat, target, curLevel + 1);
                sum -= mat[curLevel][i];
            }
        }
    }

    public static void main(String[] args) {
        MinimizeTheDifference minimizeTheDifference = new MinimizeTheDifference();
        minimizeTheDifference.minimizeTheDifference(new int[][]{{1},{2},{3}}, 100);
    }
}
