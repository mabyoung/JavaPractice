package OldExams2016.Dynamic;

public class Bonus {
    public int getMost(int[][] board) {
        int[][] bonus = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 0 && j == 0) {
                    bonus[i][j] = board[i][j];
                } else if (i == 0) {
                    bonus[i][j] = board[i][j] + bonus[i][j - 1];
                } else if (j == 0) {
                    bonus[i][j] = board[i][j] + bonus[i - 1][j];
                } else {
                    bonus[i][j] = board[i][j] + Math.max(bonus[i][j - 1], bonus[i - 1][j]);
                }
            }
        }
        return bonus[5][5];
    }
}
