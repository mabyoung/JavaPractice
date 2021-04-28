package OldExams2016;

import java.util.ArrayList;
import java.util.List;

/**
 * 请设计一个高效算法，再给定的字符串数组中，找到包含"Coder"的字符串(不区分大小写)，并将其作为一个新的数组返回。
 * 结果字符串的顺序按照"Coder"出现的次数递减排列，若两个串中"Coder"出现的次数相同，则保持他们在原数组中的位置关系。
 * 给定一个字符串数组A和它的大小n，请返回结果数组。保证原数组大小小于等于300,其中每个串的长度小于等于200。同时保证一定存在包含coder的字符串。
 */
public class Coder {
    public class StringWithCoderNum {
        String string;
        int coderNum;

        StringWithCoderNum(String string, int coderNum) {
            this.string = string;
            this.coderNum = coderNum;
        }
    }

    public String[] findCoder(String[] A, int n) {
        List<StringWithCoderNum> list = new ArrayList<>();
        for (String item : A) {
            int coderNum = this.getCoderNum(item);
            if (coderNum > 0) {
                list.add(new StringWithCoderNum(item, coderNum));
            }
        }
        list.sort((o1, o2) -> o2.coderNum - o1.coderNum);
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i).string;
        }
        return result;
    }

    private int getCoderNum(String string) {
        string = string.toLowerCase();
        return (string.length() - string.replace("coder", "").length()) / "coder".length();
    }

    public static void main(String[] args) {
        Coder coder = new Coder();
        String[] result = coder.findCoder(new String[]{"i am a coder", "Coder Coder", "Code"}, 3);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
