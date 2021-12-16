package LeetCode.String;

public class IsPrefixString {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            stringBuilder.append(words[i]);
            if (stringBuilder.length() > s.length()) {
                return false;
            }
            if (stringBuilder.length() == s.length()) {
                return stringBuilder.toString().equals(s);
            }
        }
        return false;
    }
}
