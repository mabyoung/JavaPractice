package OldExams2016.String;

import java.util.ArrayList;
import java.util.List;

/**
 * 现在有一个字符串列表，和一个关键词列表，请设计一个高效算法，检测出含关键字列表中关键字(一个或多个)的字符串。
 * 给定字符串数组A及它的大小n以及关键词数组key及它的大小m，请返回一个排好序的含关键词的字符串序号的列表。
 * 保证所有字符串长度小于等于100，关键词个数小于等于100，字符串个数小于等于200。保证所有字符串全部由小写英文字符组成。若不存在含关键字的字符串，请返回一个只含-1的数组。
 */
public class KeywordDetect {
    public int[] containKeyword(String[] A, int n, String[] keys, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            for (String key : keys) {
                if (A[i].contains(key)) {
                    list.add(i);
                    break;
                }
            }
        }
        if (list.isEmpty()) {
            return new int[]{-1};
        } else {
            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        KeywordDetect keywordDetect = new KeywordDetect();
        int[] result = keywordDetect.containKeyword(new String[]{"nowcoder", "hello", "now"}, 3, new String[]{"coder", "now"}, 2);
        for (int item : result) {
            System.out.println(item);
        }
    }
}
