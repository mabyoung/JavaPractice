package LeetCode.Dynamic;

/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie,"ACE"is a subsequence of"ABCDE"while"AEC"is not).
 *
 * Here is an example:
 * S ="rabbbit", T ="rabbit"
 *
 * Return3.
 */
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        int dp[][] = new int[T.length()+1][S.length()+1];
        dp[0][0] = 1;
        for (int i = 1; i <= T.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= S.length(); i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= T.length(); i++) {
            for (int j = 1; j <=S.length(); j++) {
                if (T.charAt(i-1) == S.charAt(j-1)) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[T.length()][S.length()];
    }

    public static void main(String[] args) {
        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        System.out.println(distinctSubsequences.numDistinct("rabbbit", "rabbit"));
    }
}
