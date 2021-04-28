package CrackingTheCodingInterview.Dynamic;

public class Queens {
    private int result = 0;

    public int nQueens(int n) {
        int[][] board = new int[n][n];
        dfs(board, 0);
        return result;
    }

    private void dfs(int[][] board, int x) {
        if (x == board.length) {
            result++;
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, x, i)) {
                board[x][i] = 1;
                dfs(board, x + 1);
                board[x][i] = 0;
            }
        }
    }

    private boolean isValid(int[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == 1) {
                return false;
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            if (board[x][j] == 1) {
                return false;
            }
        }
        for (int i = 1; i < board.length; i++) {
            if ((x - i) >= 0 && (y - i) >= 0 && board[x - i][y - i] == 1) {
                return false;
            }
            if ((x - i) >= 0 && (y + i) < board.length && board[x - i][y + i] == 1) {
                return false;
            }
            if ((x + i) < board.length && (y - i) >= 0 && board[x + i][y - i] == 1) {
                return false;
            }
            if ((x + i) < board.length && (y + i) < board.length && board[x + i][y + i] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Queens queens = new Queens();
        System.out.println(queens.nQueens(4));
    }
}
