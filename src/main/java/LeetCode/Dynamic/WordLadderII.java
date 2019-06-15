package LeetCode.Dynamic;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start ="hit"
 * end ="cog"
 * dict =["hot","dot","dog","lot","log"]
 * Return
 *   [
 *     ["hit","hot","dot","dog","cog"],
 *     ["hit","hot","lot","log","cog"]
 *   ]
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class WordLadderII {
    private int minLength = Integer.MAX_VALUE;

    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<String> current = new ArrayList<>();
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        findLaddersHelper(start, end, dict, current, result);
        for (ArrayList<String> strings : result) {
            if (strings.size() > minLength){
                result.remove(strings);
            }else{
                strings.add(0, start);
                strings.add(end);
            }
        }
        return result;
    }

    public void findLaddersHelper(String now, String end, HashSet<String> dict, ArrayList<String> current, ArrayList<ArrayList<String>> result) {
        if (isNear(now, end)) {
            if (current.size() <= minLength){
                minLength = current.size();
                result.add(new ArrayList<>(current));
            }
        }
        for (String s : dict) {
            if (!current.contains(s) && isNear(s, now)) {
                current.add(s);
                findLaddersHelper(s, end, dict, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    public boolean isNear(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        WordLadderII wordLadderII = new WordLadderII();
        String start = "hit";
        String end = "cog";
        HashSet<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        ArrayList<ArrayList<String>> ladders = wordLadderII.findLadders(start, end, dict);
        System.out.println(ladders);
    }
}
