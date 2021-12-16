package LeetCode.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindWords {
    public String[] findWords(String[] words) {
        Set<Character> set1 = new HashSet<>();
        for (char item : "qwertyuiopQWERTYUIOP".toCharArray()) {
            set1.add(item);
        }
        Set<Character> set2 = new HashSet<>();
        for (char item : "asdfghjklASDFGHJKL".toCharArray()) {
            set2.add(item);
        }
        Set<Character> set3 = new HashSet<>();
        for (char item : "zxcvbnmZXCVBNM".toCharArray()) {
            set3.add(item);
        }
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (isOk(word, set1, set2, set3)) {
                list.add(word);
            }
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public boolean isOk(String word, Set<Character> set1, Set<Character> set2, Set<Character> set3) {
        int b1 = 0;
        int b2 = 0;
        int b3 = 0;
        for (char item : word.toCharArray()) {
            if (set1.contains(item)) {
                b1 = 1;
            } else if (set2.contains(item)) {
                b2 = 1;
            } else {
                b3 = 1;
            }
        }
        return b1 + b2 + b3 <= 1;
    }
}
