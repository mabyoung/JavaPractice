package LeetCode.String;

/**
 * 请实现支持'.'and'*'.的通配符模式匹配
 * '.' 可以匹配任何单个字符。
 * '*' 可以匹配任何字符序列（包括空序列）。
 * 匹配应该覆盖整个输入字符串（而不是部分）。
 * 函数声明为：↵
 * bool isMatch(const char *s, const char *p)↵↵
 * 下面给出一些样例：↵isMatch("aa","a") → false↵isMatch("aa","aa") → true↵
 * isMatch("aaa","aa") → false↵isMatch("aa", "a*") → true↵
 * isMatch("aa", ".*") → true↵isMatch("ab", ".*") → true↵
 * isMatch("aab", "c*a*b") → true
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s.isEmpty() && p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2));
        }
        if (s.isEmpty() && p.isEmpty()) {
            return true;
        } else if (s.isEmpty() || p.isEmpty()) {
            return false;
        }
        if (p.length() > 1 && p.charAt(1) == '*') {
            if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') {
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            }
            return isMatch(s, p.substring(2));
        }
        if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
            return isMatch(s.substring(1), p.substring(1));
        }
        return false;
    }

    public static void main(String[] args) {
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        System.out.println(regularExpressionMatching.isMatch("", "c*c*"));//true
        System.out.println(regularExpressionMatching.isMatch("ab", ".*c"));//false
        System.out.println(regularExpressionMatching.isMatch("aa", ".*"));//true
        System.out.println(regularExpressionMatching.isMatch("aa", "a*"));//true
        System.out.println(regularExpressionMatching.isMatch("aaa", "ab*a*c*a"));//true
        System.out.println(regularExpressionMatching.isMatch("aaba", "ab*a*c*a"));//false
        System.out.println(regularExpressionMatching.isMatch("aab", "c*a*b"));//true
        System.out.println(regularExpressionMatching.isMatch("aa", "a"));//false
        System.out.println(regularExpressionMatching.isMatch("aa", "aa"));//true
    }
}
