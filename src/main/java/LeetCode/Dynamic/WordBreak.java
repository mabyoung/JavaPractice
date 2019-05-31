package LeetCode.Dynamic;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i= 1;i<=s.length();i++){
            for (int j=0;j<i;j++){
                if (dp[j] && dict.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("code");
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak(s, dict));
    }
}
