package CrackingTheCodingInterview.String;

/**
 * 假定我们都知道非常高效的算法来检查一个单词是否为其他字符串的子串。请将这个算法编写成一个函数，给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成，要求只能调用一次检查子串的函数。
 * 给定两个字符串s1,s2,请返回bool值代表s2是否由s1旋转而成。字符串中字符为英文字母和空格，区分大小写，字符串长度小于等于1000。
 */
public class ReverseEqual {
    public boolean checkReverseEqual(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(s2.length() - 1)) {
                String left = s1.substring(0, i+1);
                String right = s1.substring(i+1);
                if (s2.equals(right + left)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ReverseEqual reverseEqual = new ReverseEqual();
        boolean result = reverseEqual.checkReverseEqual("waterbottle", "erbottlewat");
        System.out.println(result);
    }
}
