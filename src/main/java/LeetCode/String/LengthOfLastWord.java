package LeetCode.String;

/**
 * 给出一个只包含大小写字母和空格的字符串s，请返回字符串中最后一个单词的长度
 * 如果字符串中没有最后一个单词，则返回0
 * 注意：单词的定义是仅由非空格字符组成的字符序列。
 * 例如：
 * s ="Hello World",
 * 返回5。
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        char[] chars = s.trim().toCharArray();
        int count = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                return count;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord("a "));
    }
}
