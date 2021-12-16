package LeetCode.String;

public class AreOccurrencesEqual {
    public boolean areOccurrencesEqual(String s) {
        int[] chars = new int[26];
        for (char item : s.toCharArray()) {
            chars[item - 'a']++;
        }
        int num = 0;
        for (int i = 0; i < 26; i++) {
            if (chars[i] != 0){
                num = chars[i];
                break;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (chars[i] != num && chars[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
