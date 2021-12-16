package LeetCode.Simulation;

public class CountSubIslands {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && isSubIsland(grid1, grid2, i, j)) {
                    result++;
                }
            }
        }
        return result;
    }

    public boolean isSubIsland(int[][] grid1, int[][] grid2, int x, int y) {
        if (x < 0 || y < 0 || x >= grid2.length || y >= grid2[0].length || grid2[x][y] != 1) {
            return true;
        }
        grid2[x][y] = -1;
        boolean result = true;
        if (grid1[x][y] != 1) {
            result = false;
        }
        result &= isSubIsland(grid1, grid2, x + 1, y);
        result &= isSubIsland(grid1, grid2, x, y + 1);
        result &= isSubIsland(grid1, grid2, x - 1, y);
        result &= isSubIsland(grid1, grid2, x, y - 1);
        return result;
    }

    public static void main(String[] args) {
        CountSubIslands countSubIslands = new CountSubIslands();
        int[][] grid1 = new int[][]{{1, 1, 1, 1, 0, 0}, {1, 1, 0, 1, 0, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 0, 0, 1}, {1, 1, 1, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 1, 0, 1}, {1, 0, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 0}, {1, 1, 1, 1, 1, 0}};
        int[][] grid2 = new int[][]{{1, 1, 1, 1, 0, 1}, {0, 0, 1, 0, 1, 0}, {1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 0}, {0, 1, 1, 1, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1}, {1, 0, 0, 1, 0, 0}};
        int result = countSubIslands.countSubIslands(grid1, grid2);
        System.out.println(result);
    }
}
