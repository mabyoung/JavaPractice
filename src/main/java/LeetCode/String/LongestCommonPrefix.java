package LeetCode.String;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (str.length() <= i || str.charAt(i) != c) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] str = new String[]{};
        String result = longestCommonPrefix.longestCommonPrefix(str);
        System.out.println(result);
    }
}
