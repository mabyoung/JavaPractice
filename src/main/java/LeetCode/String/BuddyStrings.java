package LeetCode.String;

public class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int[] a = new int[26];
        int[] b = new int[26];
        for (char item : s.toCharArray()) {
            a[item - 'a']++;
        }
        for (char item : goal.toCharArray()) {
            b[item - 'a']++;
        }
        boolean flag = false;
        int diffCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diffCount++;
            }
        }
        if (diffCount > 2) {
            return false;
        }
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
            if (a[i] > 1) {
                flag = true;
            }
        }
        return flag || !s.equals(goal);
    }
}
