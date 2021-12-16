package LeetCode.Simulation;

public class FlipChess {
    public int flipChess(String[] chessboard) {
        int m = chessboard.length;
        int n = chessboard[0].length();
        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            char[] chars = chessboard[i].toCharArray();
            System.arraycopy(chars, 0, board[i], 0, n);
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    char[][] copyBoard = new char[m][n];
                    for (int i1 = 0; i1 < m; i1++) {
                        System.arraycopy(board[i1], 0, copyBoard[i1], 0, n);
                    }
                    copyBoard[i][j] = 'X';
                    max = Math.max(max, flipChessCycle(copyBoard));
                }
            }
        }
        return max;
    }

    public int flipChessCycle(char[][] chessboard) {
        int result = 0;
        int value;
        while ((value = flipChess(chessboard)) != 0) {
            result += value;
        }
        return result;
    }

    public int flipChess(char[][] chessboard) {
        int m = chessboard.length;
        int n = chessboard[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (chessboard[i][j] == 'O') {
                    result += flipChess(chessboard, i, j);
                }
            }
        }
        return result;
    }

    public int flipChess(char[][] chessboard, int curI, int curJ) {
        int m = chessboard.length;
        int n = chessboard[0].length;
        if (curJ > 0 && chessboard[curI][curJ - 1] == 'X') {
            int chessA = flipChessA(chessboard, curI, curJ);
            if (chessA > 0) {
                return chessA;
            }
        }
        if (curI > 0 && chessboard[curI - 1][curJ] == 'X') {
            int chessB = flipChessB(chessboard, curI, curJ);
            if (chessB > 0) {
                return chessB;
            }
        }
        if (curI > 0 && curJ > 0 && chessboard[curI - 1][curJ - 1] == 'X') {
            int chessC = flipChessC(chessboard, curI, curJ);
            if (chessC > 0) {
                return chessC;
            }
        }
        if (curI > 0 && curJ + 1 < n && chessboard[curI - 1][curJ + 1] == 'X') {
            int chessD = flipChessD(chessboard, curI, curJ);
            if (chessD > 0) {
                return chessD;
            }
        }
        return 0;
    }

    public int flipChessA(char[][] chessboard, int curI, int curJ) {
        int m = chessboard.length;
        int n = chessboard[0].length;
        int startJ = curJ;
        while (curJ + 1 < n && chessboard[curI][curJ + 1] == 'O') {
            curJ++;
        }
        if (curJ + 1 == n || chessboard[curI][curJ + 1] == '.') {
            return 0;
        }
        for (int i = startJ; i <= curJ; i++) {
            chessboard[curI][i] = 'X';
        }
        return curJ - startJ + 1;
    }

    public int flipChessB(char[][] chessboard, int curI, int curJ) {
        int m = chessboard.length;
        int n = chessboard[0].length;
        int startI = curI;
        while (curI + 1 < m && chessboard[curI + 1][curJ] == 'O') {
            curI++;
        }
        if (curI + 1 == m || chessboard[curI + 1][curJ] == '.') {
            return 0;
        }
        for (int i = startI; i <= curI; i++) {
            chessboard[i][curJ] = 'X';
        }
        return curI - startI + 1;
    }

    public int flipChessC(char[][] chessboard, int curI, int curJ) {
        int m = chessboard.length;
        int n = chessboard[0].length;
        int startI = curI;
        int startJ = curJ;
        while (curI + 1 < m && curJ + 1 < n && chessboard[curI + 1][curJ + 1] == 'O') {
            curI++;
            curJ++;
        }
        if (curI + 1 == m || curJ + 1 == n || chessboard[curI + 1][curJ + 1] == '.') {
            return 0;
        }
        for (int i = 0; i <= curI - startI; i++) {
            chessboard[startI + i][startJ + i] = 'X';
        }
        return curI - startI + 1;
    }

    public int flipChessD(char[][] chessboard, int curI, int curJ) {
        int m = chessboard.length;
        int n = chessboard[0].length;
        int startI = curI;
        int startJ = curJ;
        while (curI + 1 < m && curJ > 0 && chessboard[curI + 1][curJ - 1] == 'O') {
            curI++;
            curJ--;
        }
        if (curI + 1 == m || curJ == 0 || chessboard[curI + 1][curJ - 1] == '.') {
            return 0;
        }
        for (int i = 0; i <= curI - startI; i++) {
            chessboard[startI + i][startJ - i] = 'X';
        }
        return curI - startI + 1;
    }

    public static void main(String[] args) {
        FlipChess flipChess = new FlipChess();
        int result = flipChess.flipChess(new String[]{"....X", "...OX", "XOOO."});
        System.out.println(result);
    }
}
