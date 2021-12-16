package LeetCode.Array;

public class ValidTicTacToe {
    public boolean validTicTacToe(String[] board) {
        int oCount = 0;
        int xCount = 0;
        char[][] copyBoard = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                copyBoard[i][j] = board[i].charAt(j);
                if (copyBoard[i][j] == 'X') {
                    xCount++;
                } else if (copyBoard[i][j] == 'O') {
                    oCount++;
                }
            }
        }
        if (xCount != oCount && xCount - 1 != oCount) {
            return false;
        }
        if (isWin(copyBoard, 'X') && isWin(copyBoard, 'O')) {
            return false;
        }
        if (isWin(copyBoard, 'X') && xCount == oCount) {
            return false;
        }
        if (isWin(copyBoard, 'O') && xCount != oCount){
            return false;
        }
        return true;
    }

    public boolean isWin(char[][] copyBoard, char c) {
        for (int i = 0; i < 3; i++) {
            if (copyBoard[i][0] == c && copyBoard[i][1] == c && copyBoard[i][2] == c) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (copyBoard[0][j] == c && copyBoard[1][j] == c && copyBoard[2][j] == c) {
                return true;
            }
        }
        if (copyBoard[0][0] == c && copyBoard[1][1] == c && copyBoard[2][2] == c) {
            return true;
        }
        if (copyBoard[2][0] == c && copyBoard[1][1] == c && copyBoard[0][2] == c) {
            return true;
        }
        return false;
    }
}
