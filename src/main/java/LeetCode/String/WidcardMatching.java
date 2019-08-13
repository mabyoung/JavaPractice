package LeetCode.String;

/**
 * Implement wildcard pattern matching with support for'?'and'*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */
public class WidcardMatching {

    public boolean isMatch(String s, String p) {
        int row = p.length();
        int col = s.length();
        boolean[][] dp = new boolean[row + 1][col + 1];
        dp[0][0] = true;
        for (int i = 0; i < row; i++) {
            if (p.charAt(i) == '*' && dp[i][0]) {
                dp[i + 1][0] = true;
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (p.charAt(i - 1) == '*' && (dp[i - 1][j - 1] || dp[i][j - 1] || dp[i - 1][j])) {
                    dp[i][j] = true;
                } else if ((p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') && dp[i - 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[row][col];
    }


    public static void main(String[] args) {
        WidcardMatching widcardMatching = new WidcardMatching();
        System.out.println(widcardMatching.isMatch("a", "a*"));
        System.out.println(widcardMatching.isMatch("aa", "a"));
        System.out.println(widcardMatching.isMatch("aa", "aa"));
        System.out.println(widcardMatching.isMatch("aaa", "aa"));
        System.out.println(widcardMatching.isMatch("aa", "*"));
        System.out.println(widcardMatching.isMatch("aa", "a*"));
        System.out.println(widcardMatching.isMatch("ab", "?*"));
        System.out.println(widcardMatching.isMatch("aab", "c*a*b"));
    }
}
