package LeetCode.Graph;

public class ColorTheGrid {
    private int result = 0;

    public int colorTheGrid(int m, int n) {
        int[][] grid = new int[m][n];
        dfs(grid, 0, 0);
        return result;
    }

    public void dfs(int[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        int[] color = new int[4];
        if (x >= 1) {
            int top = grid[x - 1][y];
            color[top] = 1;
        }
        if (y >= 1) {
            int left = grid[x][y - 1];
            color[left] = 1;
        }
        if (x == m - 1 && y == n - 1) {
            for (int i = 1; i <= 3; i++) {
                if (color[i] == 0) {
                    result = (result + 1) % 1000000007;
                }
            }
            return;
        }
        int nextX = x;
        int nextY = y + 1;
        if (nextY >= n) {
            nextX++;
            nextY = 0;
        }
        for (int i = 1; i <= 3; i++) {
            if (color[i] == 0) {
                grid[x][y] = i;
                dfs(grid, nextX, nextY);
            }
        }
    }

    public static void main(String[] args) {
        ColorTheGrid colorTheGrid = new ColorTheGrid();
        int result = colorTheGrid.colorTheGrid(1, 1);
        System.out.println(result);
    }
}
