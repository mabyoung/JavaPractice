package LeetCode.String;

/**
 * 实现函数 strStr。
 * 函数声明如下：
 * char *strStr(char *haystack, char *needle)
 * 返回一个指针，指向needle第一次在haystack中出现的位置，如果needle不是haystack的子串，则返回null。
 */
public class ImplementStrStr {
    public String strStr(String haystack, String needle) {
        if ("".equals(haystack) && "".equals(needle)) {
            return "";
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (isSame(haystack.substring(i), needle)) {
                return haystack.substring(i);
            }
        }
        return null;
    }

    private boolean isSame(String a, String b) {
        for (int i = 0; i < b.length(); i++) {
            if (i >= a.length() || a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ImplementStrStr implementStrStr = new ImplementStrStr();
        String result = implementStrStr.strStr("aaa", "aaaaa");
        System.out.println(result);
    }
}
