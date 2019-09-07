package LeetCode.Search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * N皇后问题是把N个皇后放在一个N×N棋盘上，使皇后之间不会互相攻击。
 *
 * 给出一个整数n，返回n皇后问题的所有摆放方案
 * 例如：
 * 4皇后问题有两种摆放方案
 */
public class NQueens {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(result, board, n, 0);
        return result;
    }

    public void dfs(ArrayList<String[]> result, char[][] board, int n, int row) {
        if (row == n) {
            result.add(boardTranslate(board, n));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(board, n, row, col)) {
                board[row][col] = 'Q';
                dfs(result, board, n, row + 1);
                board[row][col] = '.';
            }
        }
    }

    public String[] boardTranslate(char[][] board, int n) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                stringBuilder.append(board[i][j]);
            }
            result[i] = stringBuilder.toString();
        }
        return result;
    }

    public boolean isValid(char[][] board, int n, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        int i = row, j = col;
        while (i < n && j < n && i >= 0 && j >= 0) {
            if (board[i--][j--] == 'Q') {
                return false;
            }
        }
        i = row;
        j = col;
        while (i < n && j < n && i >= 0 && j >= 0) {
            if (board[i--][j++] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        ArrayList<String[]> strings = nQueens.solveNQueens(5);
        for (String[] string : strings) {
            System.out.println(Arrays.toString(string));
        }
    }
}
