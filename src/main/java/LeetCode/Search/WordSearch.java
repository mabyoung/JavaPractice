package LeetCode.Search;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * For example,
 * Given board =
 *
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * word ="ABCCED", -> returnstrue,
 * word ="SEE", -> returnstrue,
 * word ="ABCB", -> returnsfalse.
 */
public class WordSearch {
    private boolean flag = false;
    private int visit[][];

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        visit = new int[m][n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(index) == board[i][j]) {
                    dfs(board, word, 0, m, n, i, j);
                }
            }
        }
        return flag;
    }

    public void dfs(char[][] board, String word, int wordIndex, int m, int n, int i, int j) {
        if (flag){
            return;
        }
        if (wordIndex == word.length()) {
            flag = true;
            return;
        }
        if (i < 0 || i >= m || j < 0 || j >= n || word.charAt(wordIndex) != board[i][j] || visit[i][j] == 1) {
            return;
        }
        visit[i][j] = 1;
        dfs(board, word, wordIndex + 1, m, n, i - 1, j);
        dfs(board, word, wordIndex + 1, m, n, i + 1, j);
        dfs(board, word, wordIndex + 1, m, n, i, j - 1);
        dfs(board, word, wordIndex + 1, m, n, i, j + 1);
        visit[i][j] = 0;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, "ABCCED"));
    }
}
