package LeetCode.Simulation;

public class RotateGrid {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int row0 = 0;
        int row1 = m - 1;
        int col0 = 0;
        int col1 = n - 1;
        while (row0 < row1 && col0 < col1) {
            int cycle = (row1 - row0 + col1 - col0) * 2;
            for (int i = 0; i < k%cycle; i++) {
                rotatedGrid(grid, row0, row1, col0, col1);
            }
            row0++;
            row1--;
            col0++;
            col1--;
        }
        return grid;
    }

    public void rotatedGrid(int[][] grid, int row0, int row1, int col0, int col1) {
        int tmp = grid[row0][col0];
        for (int j = col0; j < col1; j++) {
            grid[row0][j] = grid[row0][j + 1];
        }
        for (int i = row0; i < row1; i++) {
            grid[i][col1] = grid[i + 1][col1];
        }
        for (int j = col1; j > col0; j--) {
            grid[row1][j] = grid[row1][j - 1];
        }
        for (int i = row1; i > row0; i--) {
            grid[i][col0] = grid[i - 1][col0];
        }
        grid[row0 + 1][col0] = tmp;
    }
}
