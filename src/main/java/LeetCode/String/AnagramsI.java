package LeetCode.String;

import java.util.*;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * <p>
 * Note: All inputs will be in lower-case.
 * <p>
 * 首先简单介绍一下Anagram（回文构词法）。Anagrams是指由颠倒字母顺序组成的单词，“tea”会变成“eat”。
 * <p>
 * 回文构词法有一个特点：单词里的字母的种类和数目没有改变，只是改变了字母的排列顺序。
 * <p>
 * For example:
 * <p>
 * Input:  ["tea","and","ate","eat","den"]
 * <p>
 * Output:   ["tea","ate","eat"]
 */
public class AnagramsI {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = charSort(str);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        for (String s : map.keySet()) {
            if (map.get(s).size() > 1) {
                result.addAll(map.get(s));
            }
        }
        return result;
    }

    public String charSort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        ArrayList<String> result = new AnagramsI().anagrams(new String[]{"tea", "eat"});
        result.forEach(System.out::println);
    }
}
