package LeetCode.Array;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Given a 2D board containing'X'and'O', capture all regions surrounded by'X'.
 *
 * A region is captured by flipping all'O's into'X's in that surrounded region .
 *
 * For example,
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class SurroundedRegions {
    public void save(char[][] board, int i, int j) {
        if (i - 1 >= 0 && (board[i - 1][j] == 'O')) {
            board[i - 1][j] = '-';
            save(board, i - 1, j);
        }
        if (i + 1 < board.length && (board[i + 1][j] == 'O')) {
            board[i + 1][j] = '-';
            save(board, i + 1, j);
        }
        if (j - 1 >= 0 && (board[i][j - 1] == 'O')) {
            board[i][j - 1] = '-';
            save(board, i, j - 1);
        }
        if (j + 1 < board[0].length && (board[i][j + 1] == 'O')) {
            board[i][j + 1] = '-';
            save(board, i, j + 1);
        }
    }

    public void solve(char[][] board) {
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                if ((i==0 || j==0 || i == board.length-1 || j == board[i].length-1) && board[i][j] == 'O'){
                    board[i][j] = '-';
                    save(board, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '-') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void main(String[] args) {
//        char a[][] = {{'O', 'O'}, {'O', 'O'}};
        char a[][]={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        surroundedRegions.solve(a);
        for (char[] chars : a) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}
