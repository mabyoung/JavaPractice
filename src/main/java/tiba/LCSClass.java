package tiba;

/**
 * 给定两个字符串str1和str2,输出两个字符串的最长公共子串，如果最长公共子串为空，输出-1。
 */
public class LCSClass {
    /**
     * longest common substring
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < n; j++) {
            dp[m][j] = 0;
        }
        int max = 0;
        int maxi = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                if (dp[i + 1][j + 1] > max) {
                    max = dp[i + 1][j + 1];
                    maxi = i + 1;
                }
            }
        }
        if (max > 0) {
            return str1.substring(maxi - max, maxi);
        } else {
            return "-1";
        }
    }

    public static void main(String[] args) {
        LCSClass lcsClass = new LCSClass();
        String result = lcsClass.LCS("1AB2345CD", "12345EF");
        System.out.println(result);
    }
}
