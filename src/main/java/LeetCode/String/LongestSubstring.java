package LeetCode.String;

public class LongestSubstring {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        int[] letter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letter[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < letter.length; i++) {
            if (letter[i] > 0 && letter[i] < k) {
                String str1 = s.substring(0, s.indexOf('a' + i));
                String str2 = s.substring(s.lastIndexOf('a' + i) + 1);
                if (letter[i] == 1) {
                    return Math.max(longestSubstring(str1, k), longestSubstring(str2, k));
                } else {
                    String str3 = s.substring(s.indexOf('a' + i) + 1, s.lastIndexOf('a' + i));
                    int max = Math.max(longestSubstring(str1, k), longestSubstring(str2, k));
                    return Math.max(max, longestSubstring(str3, k));
                }
            }
        }
        return s.length();
    }

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println(longestSubstring.longestSubstring("baaabcb", 3));
    }
}
