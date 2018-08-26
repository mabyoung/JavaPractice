package SwordOffer.String;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * https://www.nowcoder.com/questionTerminal/45327ae22b7b413ea21df13ee7d6429c
 */
public class Match {
    public static boolean matchHelper(char[] str, int i, char[] pattern, int j) {
        if (i >= str.length && j >= pattern.length) {
            return true;
        }
        if (i < str.length && j >= pattern.length) {
            return false;
        }
        if (j + 1 < pattern.length && pattern[j + 1] == '*') {
            if (i < str.length && (str[i] == pattern[j] || pattern[j] == '.')) {
                return matchHelper(str, i, pattern, j + 2) || matchHelper(str, i + 1, pattern, j);
            } else {
                return matchHelper(str, i, pattern, j + 2);
            }
        }
        if (pattern[j] == '.' && i < str.length) {
            return matchHelper(str, i + 1, pattern, j + 1);
        }
        if (i >= str.length || str[i] != pattern[j]) {
            return false;
        }
        return matchHelper(str, i + 1, pattern, j + 1);
    }

    public static boolean match(char[] str, char[] pattern) {
        return matchHelper(str, 0, pattern, 0);
    }

    public static void main(String[] args) {
        char[] str = "a".toCharArray();
        char[] pattern = ".*".toCharArray();
        System.out.println(match(str, pattern));
    }
}
