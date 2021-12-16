package LeetCode.String;

public class IndexOf {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }
        char[] chars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isOk(chars, needleChars, i)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isOk(char[] chars, char[] needleChars, int startIndex) {
        for (int i = 0; i < needleChars.length; i++) {
            if (startIndex + i >= chars.length || chars[startIndex + i] != needleChars[i]) {
                return false;
            }
        }
        return true;
    }
}
