package LeetCode.Array;

public class ColorBorder {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = grid[i][j];
            }
        }
        dfs(grid, row, col, grid[row][col], color, visited, result);
        return result;
    }

    public void dfs(int[][] grid, int row, int col, int beforeColor, int targetColor, boolean[][] visited, int[][] result) {
        int m = grid.length;
        int n = grid[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || grid[row][col] != beforeColor) {
            return;
        }
        if (row == 0 || row == m - 1 || col == 0 || col == n - 1 || grid[row + 1][col] != beforeColor || grid[row - 1][col] != beforeColor
                || grid[row][col + 1] != beforeColor || grid[row][col - 1] != beforeColor) {
            result[row][col] = targetColor;
        }
        visited[row][col] = true;
        dfs(grid, row + 1, col, beforeColor, targetColor, visited, result);
        dfs(grid, row - 1, col, beforeColor, targetColor, visited, result);
        dfs(grid, row, col + 1, beforeColor, targetColor, visited, result);
        dfs(grid, row, col - 1, beforeColor, targetColor, visited, result);
    }

}
