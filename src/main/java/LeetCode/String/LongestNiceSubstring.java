package LeetCode.String;

import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubstring {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        while (n > 0) {
            for (int i = 0; i <= s.length() - n; i++) {
                String subString = s.substring(i, i + n);
                if (isNice(subString)) {
                    return subString;
                }
            }
            n--;
        }
        return "";
    }

    public boolean isNice(String str) {
        char[] chars = str.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char aChar : chars) {
            set.add(aChar);
        }
        for (char aChar : chars) {
            if (aChar >= 'a' && aChar <= 'z') {
                if (!set.contains((char) (aChar + ('A' - 'a')))) {
                    return false;
                }
            } else {
                if (!set.contains((char) (aChar - ('A' - 'a')))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LongestNiceSubstring longestNiceSubstring = new LongestNiceSubstring();
        String result = longestNiceSubstring.longestNiceSubstring("jcJ");
        System.out.println(result);
    }
}
