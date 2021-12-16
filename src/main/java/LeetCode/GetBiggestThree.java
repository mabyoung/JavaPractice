package LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class GetBiggestThree {
    class BigThree {
        List<Integer> list = new ArrayList<>();

        void add(Integer item) {
            if (list.contains(item)) {
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) < item) {
                    list.add(i, item);
                    break;
                }
            }
            if (list.isEmpty()){
                list.add(item);
            }
            if (list.size() > 3) {
                list.remove(3);
            }
        }
    }

    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum1 = new int[m + 1][n + 2];
        int[][] sum2 = new int[m + 1][n + 2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum1[i][j] = sum1[i - 1][j - 1] + grid[i - 1][j - 1];
                sum2[i][j] = sum2[i - 1][j + 1] + grid[i - 1][j - 1];
            }
        }
        BigThree bigThree = new BigThree();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                bigThree.add(grid[i][j]);
                int c = 1;
                while (j - c >= 0 && j + c < n && i + 2 * c < m) {
                    int sumA = sum1[i + 1 + c][j + 1 + c] - sum1[i][j] + sum1[i + 1 + 2 * c][j + 1] - sum1[i + c][j - c];
                    int sumB = sum2[i + 1 + 2 * c][j + 1] - sum2[i + c][j + 2 + c] + sum2[i + 1 + c][j + 1 - c] - sum2[i][j + 2];
                    int sum = sumA + sumB - grid[i][j] - grid[i + c][j - c] - grid[i + c][j + c] - grid[i + 2 * c][j];
                    bigThree.add(sum);
                    c++;
                }
            }
        }
        int[] result = new int[bigThree.list.size()];
        for (int i = 0; i < bigThree.list.size(); i++) {
            result[i] = bigThree.list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        GetBiggestThree getBiggestThree = new GetBiggestThree();
        int[][] grid = new int[][]{{3, 4, 5, 1, 3}, {3, 3, 4, 2, 3}, {20, 30, 200, 40, 10}, {1, 5, 5, 4, 1}, {4, 3, 2, 2, 5}};
        int[] result = getBiggestThree.getBiggestThree(grid);
        for (int item : result) {
            System.out.println(item);
        }
    }
}
