package tiba;

/**
 * 对于一个给定的字符串，我们需要在线性(也就是O(n))的时间里对它做一些变形。首先这个字符串中包含着一些空格，就像"Hello World"一样，
 * 然后我们要做的是把着个字符串中由空格隔开的单词反序，同时反转每个字符的大小写。比如"Hello World"变形后就变成了"wORLD hELLO"。
 */
public class StringTransfer {
    public String trans(String s, int n) {
        String[] words = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            stringBuilder.append(wordTrans(words[words.length - i - 1])).append(" ");
        }
        String trim = stringBuilder.toString().trim();
        if (s.startsWith(" ")) {
            return trim + " ";
        } else if (s.endsWith(" ")) {
            return " " + trim;
        } else {
            return trim;
        }
    }

    public String wordTrans(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : word.toCharArray()) {
            stringBuilder.append(caseTrans(c));
        }
        return stringBuilder.toString();
    }

    public char caseTrans(char c) {
        if (c >= 'a' && c <= 'z') {
            return (char) ('A' - 'a' + c);
        } else if (c >= 'A' && c <= 'Z') {
            return (char) (c - 'A' + 'a');
        } else {
            return c;
        }
    }

    public static void main(String[] args) {
        StringTransfer stringTransfer = new StringTransfer();
        String result = stringTransfer.trans("This is a sample ", 16);
        System.out.println(result);
    }
}
