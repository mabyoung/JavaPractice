package LeetCode.Search;

/**
 * 继续思考“n-queens”问题
 * 这次我们不是输出皇后的排列情况，而是输出n皇后问题一共有多少种解法
 */
public class NQueensII {
    private int result = 0;

    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        dfs(board, 0, 0);
        return result;
    }

    private void dfs(int[][] board, int i, int count) {
        if (count == board.length) {
            result++;
        } else if (i < board.length) {
            for (int j = 0; j < board.length; j++) {
                if (isValid(board, i, j)) {
                    board[i][j] = 1;
                    dfs(board, i + 1, count + 1);
                    board[i][j] = 0;
                }
            }
        }
    }

    private boolean isValid(int[][] board, int i, int j) {
        for (int x = 0; x < board.length && x != i; x++) {
            if (board[x][j] == 1) {
                return false;
            }
        }
        for (int y = 0; y < board.length && y != j; y++) {
            if (board[i][y] == 1) {
                return false;
            }
        }
        for (int x = 1; x < board.length; x++) {
            if (i - x >= 0 && j - x >= 0 && board[i - x][j - x] == 1) {
                return false;
            }
            if (i - x >= 0 && j + x < board.length && board[i - x][j + x] == 1) {
                return false;
            }
            if (i + x < board.length && j - x >= 0 && board[i + x][j - x] == 1) {
                return false;
            }
            if (i + x < board.length && j + x < board.length && board[i + x][j + x] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueensII nQueensII = new NQueensII();
        System.out.println(nQueensII.totalNQueens(5));
    }
}
