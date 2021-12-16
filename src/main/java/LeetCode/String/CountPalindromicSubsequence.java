package LeetCode.String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountPalindromicSubsequence {
    public int countPalindromicSubsequence(String s) {
        int result = 0;
        int[][] index = new int[26][2];
        for (int[] ints : index) {
            Arrays.fill(ints, -1);
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int alpha = chars[i] - 'a';
            if (index[alpha][0] == -1) {
                index[alpha][0] = i;
            }
            index[alpha][1] = Math.max(index[alpha][1], i);
        }
        for (int i = 0; i < 26; i++) {
            if (index[i][0] != index[i][1]) {
                Set<Character> set = new HashSet<>();
                for (int j = index[i][0] + 1; j < index[i][1]; j++) {
                    set.add(chars[j]);
                }
                result += set.size();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountPalindromicSubsequence countPalindromicSubsequence = new CountPalindromicSubsequence();
        int result = countPalindromicSubsequence.countPalindromicSubsequence("bbcbaba");
        System.out.println(result);
    }
}
