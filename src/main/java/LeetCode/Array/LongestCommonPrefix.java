package LeetCode.Array;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != c) {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

}
