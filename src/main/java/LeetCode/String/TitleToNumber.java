package LeetCode.String;

public class TitleToNumber {
    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int result = 0;
        for (char item : chars) {
            result = result * 26 + (item - 'A' + 1);
        }
        return result;
    }
}
