package LeetCode.Simulation;

public class SurfaceArea {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count += grid[i][j];
            }
        }
        int result = count * 6;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 1) {
                    result -= 2 * (grid[i][j] - 1);
                }
                result -= getBehind(grid, i, j);
            }
        }
        return result;
    }

    public int getBehind(int[][] grid, int x, int y) {
        int result = 0;
        int n = grid.length;
        if (x + 1 < n) {
            result += Math.min(grid[x][y], grid[x + 1][y]);
        }
        if (x - 1 >= 0) {
            result += Math.min(grid[x][y], grid[x - 1][y]);
        }
        if (y + 1 < n) {
            result += Math.min(grid[x][y], grid[x][y + 1]);
        }
        if (y - 1 >= 0) {
            result += Math.min(grid[x][y], grid[x][y - 1]);
        }
        return result;
    }
}
