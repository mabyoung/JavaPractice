package LeetCode.Simulation;

public class CheckMove {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        if (isOk1(board, rMove, cMove, color) || isOk2(board, rMove, cMove, color) || isOk3(board, rMove, cMove, color) || isOk4(board, rMove, cMove, color) || isOk5(board, rMove, cMove, color) || isOk6(board, rMove, cMove, color) || isOk7(board, rMove, cMove, color) || isOk8(board, rMove, cMove, color)) {
            return true;
        }
        return false;
    }

    public boolean isOk1(char[][] board, int rMove, int cMove, char color) {
        int n = board.length;
        if (cMove + 2 > n) {
            return false;
        }
        char nextMove = board[rMove][++cMove];
        if (nextMove == '.' || nextMove == color) {
            return false;
        }
        while (++cMove < n) {
            nextMove = board[rMove][cMove];
            if (nextMove == '.') {
                return false;
            }
            if (nextMove == color) {
                return true;
            }
        }
        return false;
    }

    public boolean isOk2(char[][] board, int rMove, int cMove, char color) {
        int n = board.length;
        if (cMove < 2) {
            return false;
        }
        char nextMove = board[rMove][--cMove];
        if (nextMove == '.' || nextMove == color) {
            return false;
        }
        while (--cMove >= 0) {
            nextMove = board[rMove][cMove];
            if (nextMove == '.') {
                return false;
            }
            if (nextMove == color) {
                return true;
            }
        }
        return false;
    }

    public boolean isOk3(char[][] board, int rMove, int cMove, char color) {
        int n = board.length;
        if (rMove < 2) {
            return false;
        }
        char nextMove = board[--rMove][cMove];
        if (nextMove == '.' || nextMove == color) {
            return false;
        }
        while (--rMove >= 0) {
            nextMove = board[rMove][cMove];
            if (nextMove == '.') {
                return false;
            }
            if (nextMove == color) {
                return true;
            }
        }
        return false;
    }

    public boolean isOk4(char[][] board, int rMove, int cMove, char color) {
        int n = board.length;
        if (rMove + 2 > n) {
            return false;
        }
        char nextMove = board[++rMove][cMove];
        if (nextMove == '.' || nextMove == color) {
            return false;
        }
        while (++rMove < n) {
            nextMove = board[rMove][cMove];
            if (nextMove == '.') {
                return false;
            }
            if (nextMove == color) {
                return true;
            }
        }
        return false;
    }

    public boolean isOk5(char[][] board, int rMove, int cMove, char color) {
        int n = board.length;
        if (rMove < 2 || cMove < 2) {
            return false;
        }
        char nextMove = board[--rMove][--cMove];
        if (nextMove == '.' || nextMove == color) {
            return false;
        }
        while (--rMove >= 0 && --cMove >= 0) {
            nextMove = board[rMove][cMove];
            if (nextMove == '.') {
                return false;
            }
            if (nextMove == color) {
                return true;
            }
        }
        return false;
    }

    public boolean isOk6(char[][] board, int rMove, int cMove, char color) {
        int n = board.length;
        if (rMove < 2 || cMove + 2 > n) {
            return false;
        }
        char nextMove = board[--rMove][++cMove];
        if (nextMove == '.' || nextMove == color) {
            return false;
        }
        while (--rMove >= 0 && ++cMove < n) {
            nextMove = board[rMove][cMove];
            if (nextMove == '.') {
                return false;
            }
            if (nextMove == color) {
                return true;
            }
        }
        return false;
    }

    public boolean isOk7(char[][] board, int rMove, int cMove, char color) {
        int n = board.length;
        if (rMove + 2 > n || cMove < 2) {
            return false;
        }
        char nextMove = board[++rMove][--cMove];
        if (nextMove == '.' || nextMove == color) {
            return false;
        }
        while (++rMove < n && --cMove >= 0) {
            nextMove = board[rMove][cMove];
            if (nextMove == '.') {
                return false;
            }
            if (nextMove == color) {
                return true;
            }
        }
        return false;
    }

    public boolean isOk8(char[][] board, int rMove, int cMove, char color) {
        int n = board.length;
        if (rMove + 2 > n || cMove + 2 > n) {
            return false;
        }
        char nextMove = board[++rMove][++cMove];
        if (nextMove == '.' || nextMove == color) {
            return false;
        }
        while (++rMove < n && ++cMove < n) {
            nextMove = board[rMove][cMove];
            if (nextMove == '.') {
                return false;
            }
            if (nextMove == color) {
                return true;
            }
        }
        return false;
    }
}
