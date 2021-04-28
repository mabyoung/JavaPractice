package CrackingTheCodingInterview.Basis;

public class Board {
    public boolean checkWon(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (checkRow(board, i) || checkColumn(board, i)) {
                return true;
            }
        }
        return checkPositiveDiagonal(board) || checkObliqueDiagonal(board);
    }

    private boolean checkRow(int[][] board, int row) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][row] != 1) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int[][] board, int column) {
        for (int i = 0; i < board.length; i++) {
            if (board[column][i] != 1) {
                return false;
            }
        }
        return true;
    }

    private boolean checkPositiveDiagonal(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] != 1) {
                return false;
            }
        }
        return true;
    }

    private boolean checkObliqueDiagonal(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[board.length - i - 1][i] != 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board.checkWon(new int[][]{{1, 0, 1}, {1, -1, -1}, {1, -1, 0}}));
    }
}
