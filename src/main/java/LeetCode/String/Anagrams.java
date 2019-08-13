package LeetCode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 *
 * Note: All inputs will be in lower-case.
 *
 * 首先简单介绍一下Anagram（回文构词法）。Anagrams是指由颠倒字母顺序组成的单词，“tea”会变成“eat”。
 *
 * 回文构词法有一个特点：单词里的字母的种类和数目没有改变，只是改变了字母的排列顺序。
 *
 * For example:
 *
 * Input:  ["tea","and","ate","eat","den"]
 *
 * Output:   ["tea","ate","eat"]
 */
public class Anagrams {
    public class Node {
        String originType;
        String uniType;

        Node(String originType, String uniType) {
            this.originType = originType;
            this.uniType = uniType;
        }
    }

    public String parseUni(String originType) {
        char[] chars = originType.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<>();
        List<Node> nodeList = new ArrayList<>();
        for (String str : strs) {
            nodeList.add(new Node(str, parseUni(str)));
        }
        nodeList.sort((Comparator.comparing(o -> o.uniType)));
        for (int i = 1; i < nodeList.size(); i++) {
            if (nodeList.get(i).uniType.equals(nodeList.get(i - 1).uniType)) {
                result.add(nodeList.get(i - 1).originType);
            } else if (i - 2 >= 0 && nodeList.get(i - 1).uniType.equals(nodeList.get(i - 2).uniType)) {
                result.add(nodeList.get(i - 1).originType);
            }
            if (i == nodeList.size() - 1 && nodeList.get(i).uniType.equals(nodeList.get(i - 1).uniType)) {
                result.add(nodeList.get(i).originType);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> result = new Anagrams().anagrams(new String[]{"tea"});
        result.forEach(System.out::println);
    }
}
