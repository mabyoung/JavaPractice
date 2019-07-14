package LeetCode.Greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * For example,
 * S ="ADOBECODEBANC"
 * T ="ABC"
 * <p>
 * Minimum window is"BANC".
 * <p>
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string"".
 * <p>
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        char[] sList = S.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : T.toCharArray()) {
            if (map.containsKey(c)){
                map.put(c, map.get(c)-1);
            }else{
                map.put(c, 0);
            }
        }
        int begin = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;
        int minLengthBegin = 0;
        int minLengthEnd = 0;
        while (end < sList.length) {
            if (map.containsKey(sList[end])) {
                map.put(sList[end], map.get(sList[end]) + 1);
            }
            end++;
            if (mapContainsAllItem(map, T)) {
                while (true) {
                    if (!map.containsKey(sList[begin])) {
                        begin++;
                    } else if (map.get(sList[begin]) > 1) {
                        map.put(sList[begin], map.get(sList[begin]) - 1);
                        begin++;
                    } else {
                        break;
                    }
                }
                if (end - begin < minLength) {
                    minLength = end - begin;
                    minLengthBegin = begin;
                    minLengthEnd = end;
                }
            }
        }
        return S.substring(minLengthBegin, minLengthEnd);
    }

    public boolean mapContainsAllItem(Map<Character, Integer> map, String T) {
        for (char c : T.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) <= 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String result = minimumWindowSubstring.minWindow("aaa", "aa");
        System.out.println(result);
    }
}
