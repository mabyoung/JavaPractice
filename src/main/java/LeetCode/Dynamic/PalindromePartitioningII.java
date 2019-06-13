package LeetCode.Dynamic;


/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s ="aab",
 * Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.
 *
 * 思路：用s[i][j]表示下标从i到j的字符子串，f[i][j]表示s[i][j]需要的最小切点数，如果s[i][j]是回文，则f[i][j]=0;
 * 如果s[i][j]不是回文，则取从i到j的每一个点k为切点，f[i][j]=min({f[i][k]+f[k][j]})+1
 */
public class PalindromePartitioningII {
    private int[][] f = new int[1000][1000];

    public int minCut(String s) {
        return minCutHelper(s, 0, s.length() - 1);
    }

    public int minCutHelper(String s, int i, int j) {
        if (i >= j || isPalindrome(s, i, j)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int a = f[i][k] == 0 ? minCutHelper(s, i, k) : f[i][k];
            int b = f[k + 1][j] == 0 ? minCutHelper(s, k + 1, j) : f[k + 1][j];
            int now = a + b;
            if (now < min) {
                min = now;
            }
        }
        f[i][j] = min + 1;
        return f[i][j];
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioningII palindromePartitioningII = new PalindromePartitioningII();
        System.out.println(palindromePartitioningII.minCut("aabbcd"));
    }
}
