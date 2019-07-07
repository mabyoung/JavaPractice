package LeetCode.Dynamic;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 ="aabcc",
 * s2 ="dbbca",
 * When s3 ="aadbbcbcac", return true.
 * When s3 ="aadbbbaccc", return false.
 * s3是由s1和s2交织生成的，意味着s3由s1和s2组成，在s3中s1和s2字符的顺序是不能变化的，和子序列题型类似，这种题我们一般是用动态规划来解。
 *
 * 设dp[i][j]表示s3的前i+j个字符可以由s1的前i个字符和s2的前j个字符交织而成。
 * 状态转移方程：有两种情况
 * 第一个状态转移方程：
 * dp[i][j]= {(dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)}
 * dp[i-1][j]表示若s3的前i+j-1个字符能够由s1前i-1个字符和s2的前j个字符交织而成，那么只需要s1的第i个字符与s3的第i+j个字符相等（charAt索引从0开始），那么dp[i][j]=true;
 * 第二个状态转移方程：
 * dp[i][j]= {(dp[i][j-1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)}
 * dp[i-1][j]表示若s3的前i+j-1个字符能够由s1前i个字符和s2的前j-1个字符交织而成，那么只需要s2的第j个字符与s3的第i+j个字符相等（charAt索引从0开始），那么dp[i][j]=true;
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < s1.length(); i++) {
            if (dp[i][0] && s1.charAt(i) == s3.charAt(i)) {
                dp[i + 1][0] = true;
            }
        }
        for (int j = 0; j < s2.length(); j++) {
            if (dp[0][j] && s2.charAt(j) == s3.charAt(j)) {
                dp[0][j + 1] = true;
            }
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)){
                    dp[i][j] = true;
                }
                if (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)){
                    dp[i][j] = true;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        InterleavingString interleavingString = new InterleavingString();
        System.out.println(interleavingString.isInterleave(s1, s2, s3));
    }
}
