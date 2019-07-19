package LeetCode.Dynamic;

/**
 * A message containing letters fromA-Zis being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * For example,
 * Given encoded message"12", it could be decoded as"AB"(1 2) or"L"(12).
 *
 * The number of ways decoding"12"is 2.
 *
 * 思路：dp[i]表示前i-1个字符的结果。初始时dp[i]=0，如果第i-1个字符为1~9，则第i-1个字符可以单独存在，dp[i]+= dp[i-1]。
 * 如果第i-2和第i-1个字符连在一起为10~26，说明第i-2和第i-1个字符可以连在一起存在，dp[i]+= dp[i-2]。
 */
public class DecodeWays {
    public int numDecodings(String s){
        if (s == null || s.length() == 0 ||s.charAt(0) == '0'){
            return 0;
        }
        char[] sArray = s.toCharArray();
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (sArray[i-1]>='1' && sArray[i-1]<='9'){
                dp[i] = dp[i-1];
            }
            if (sArray[i-2]=='1' || (sArray[i-2] == '2' && sArray[i-1] >= '0' && sArray[i-1] <= '6')){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("01"));
    }
}
