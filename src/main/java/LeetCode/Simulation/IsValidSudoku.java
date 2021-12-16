package LeetCode.Simulation;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> set1 = new HashSet<>();
            Set<Character> set2 = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (!isValid(set1, board[i][j])) {
                    return false;
                }
                if (!isValid(set2, board[j][i])) {
                    return false;
                }
            }
        }
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        Set<Character> set3 = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isValid(set1, board[i][j])) {
                    return false;
                }
            }
            for (int j = 3; j < 6; j++) {
                if (!isValid(set2, board[i][j])) {
                    return false;
                }
            }
            for (int j = 6; j < 9; j++) {
                if (!isValid(set3, board[i][j])) {
                    return false;
                }
            }
        }
        set1 = new HashSet<>();
        set2 = new HashSet<>();
        set3 = new HashSet<>();
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isValid(set1, board[i][j])) {
                    return false;
                }
            }
            for (int j = 3; j < 6; j++) {
                if (!isValid(set2, board[i][j])) {
                    return false;
                }
            }
            for (int j = 6; j < 9; j++) {
                if (!isValid(set3, board[i][j])) {
                    return false;
                }
            }
        }
        set1 = new HashSet<>();
        set2 = new HashSet<>();
        set3 = new HashSet<>();
        for (int i = 6; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isValid(set1, board[i][j])) {
                    return false;
                }
            }
            for (int j = 3; j < 6; j++) {
                if (!isValid(set2, board[i][j])) {
                    return false;
                }
            }
            for (int j = 6; j < 9; j++) {
                if (!isValid(set3, board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(Set<Character> set, char item) {
        if (set.contains(item)) {
            return false;
        }
        if (item != '.') {
            set.add(item);
        }
        return true;
    }
}
