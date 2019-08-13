package LeetCode.Search;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> col = new HashSet<>();
            Set<Character> row = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !col.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !row.add(board[j][i])) {
                    return false;
                }
                int cubeRow = 3 * (i / 3) + (j / 3);
                int cubeCol = 3 * (i % 3) + (j % 3);
                if (board[cubeRow][cubeCol] != '.' && !cube.add(board[cubeRow][cubeCol])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] board = new char[][]{{'.', '.', '9', '7', '4', '8', '.', '.', '.'}, {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'}, {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'}, {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
        System.out.println(validSudoku.isValidSudoku(board));
    }
}
