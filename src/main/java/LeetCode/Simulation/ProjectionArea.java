package LeetCode.Simulation;

public class ProjectionArea {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0){
                    result++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            result += getMax(grid[i]);
            result += getMax(grid, i);
        }
        return result;
    }

    public int getMax(int[] nums){
        int max = nums[0];
        for (int num : nums) {
            if (num > max){
                max = num;
            }
        }
        return max;
    }

    public int getMax(int[][] grid, int col){
        int n = grid.length;
        int max = grid[0][col];
        for (int i = 0; i < n; i++) {
            if (grid[i][col] > max){
                max = grid[i][col];
            }
        }
        return max;
    }
}
