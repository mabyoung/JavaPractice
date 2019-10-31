package LeetCode.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 给出一个字符串S和一组单词L，L中单词的长度都相等，找出S中的符合以下要求的子串在S中的起始位置索引：子串为L中所有单词串联在一起(单词的顺序随意)，L中的每个单词只出现一次，中间不能有其他的字符。
 * 例如：给定S="barfoothefoobarman"，L为["foo", "bar"]，
 * 返回的索引应该是[0,9].（不用关心给出索引的顺序）
 */
public class SubstringWithConcatenationOfAllWords {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String item : L) {
            if (wordMap.containsKey(item)) {
                wordMap.put(item, wordMap.get(item) + 1);
            } else {
                wordMap.put(item, 1);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <= S.length() - L[0].length() * L.length; i++) {
            Map<String, Integer> matchMap = new HashMap<>();
            for (int matchNum = 0; matchNum < L.length; ) {
                String word = S.substring(L[0].length() * matchNum + i, L[0].length() * (matchNum + 1) + i);
                if (!wordMap.containsKey(word)) {
                    break;
                } else {
                    if (matchMap.containsKey(word)) {
                        matchMap.put(word, matchMap.get(word) + 1);
                    } else {
                        matchMap.put(word, 1);
                    }
                    if (matchMap.get(word) > wordMap.get(word)) {
                        break;
                    }
                    if (++matchNum == L.length) {
                        result.add(i);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords substringWithConcatenationOfAllWords = new SubstringWithConcatenationOfAllWords();
        ArrayList<Integer> result = substringWithConcatenationOfAllWords.findSubstring("aaa", new String[]{"a", "b"});
        System.out.println(result);
    }
}
