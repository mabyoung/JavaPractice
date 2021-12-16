package LeetCode.Array;

import java.util.HashSet;
import java.util.Set;

public class MaxProduct {
    public int maxProduct(String[] words) {
        int n = words.length;
        Set<Character>[] sets = new HashSet[n];
        for (int i = 0; i < n; i++) {
            sets[i] = new HashSet<>();
            for (char c : words[i].toCharArray()) {
                sets[i].add(c);
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!containSameChar(sets, i, j)) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }

    public boolean containSameChar(Set<Character>[] sets, int x, int y) {
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            if (sets[x].contains(c) && sets[y].contains(c)) {
                return true;
            }
        }
        return false;
    }
}
