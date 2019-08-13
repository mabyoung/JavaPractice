package LeetCode.Search;

import java.util.Arrays;

public class SudokuSolver {
    private boolean flag = true;

    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    private void dfs(char[][] board, int i, int j) {
        if (i >= 9) {
            flag = false;
            return;
        }
        if (flag) {
            if (board[i][j] != '.') {
                if (j >= 8) {
                    dfs(board, i + 1, 0);
                } else {
                    dfs(board, i, j + 1);
                }
            } else {
                for (char num = '1'; num <= '9'; num++) {
                    if (isOk(board, i, j, num)) {
                        board[i][j] = num;
                        if (j >= 8) {
                            dfs(board, i + 1, 0);
                        } else {
                            dfs(board, i, j + 1);
                        }
                        if (flag) {
                            board[i][j] = '.';
                        }
                    }
                }
            }
        }
    }

    private boolean isOk(char[][] board, int i, int j, char num) {
        int n = board.length;
        for (int k = 0; k < n; k++) {
            if (board[i][k] == num || board[k][j] == num) {
                return false;
            }
        }
        for (int k = i / 3 * 3; k < i / 3 * 3 + 3; k++) {
            for (int l = j / 3 * 3; l < j / 3 * 3 + 3; l++) {
                if (k != i && l != j && board[k][l] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
        char[][] board = new char[][]{{'.', '.', '9', '7', '4', '8', '.', '.', '.'}, {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'}, {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'}, {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
        sudokuSolver.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }
}