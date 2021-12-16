package LeetCode.Simulation;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int landCount = 0;
        int edgeCount = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    landCount++;
                }
                edgeCount += getEdgeNum(grid, i, j);
            }
        }
        return landCount * 4 - edgeCount;
    }

    public int getEdgeNum(int[][] grid, int i, int j) {
        if (grid[i][j] == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            result++;
        }
        if (i + 1 < m && grid[i + 1][j] == 1) {
            result++;
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            result++;
        }
        if (j + 1 < n && grid[i][j + 1] == 1) {
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        IslandPerimeter islandPerimeter = new IslandPerimeter();

    }
}
