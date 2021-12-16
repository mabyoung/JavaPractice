package LeetCode.Array;

import java.util.*;

public class LongestWord {
    public String longestWord(String[] words) {
        List<String> list = new ArrayList<>(Arrays.asList(words));
        list.sort(String::compareTo);
        Set<String> set = new HashSet<>();
        for (String item : list) {
            if (item.length() == 1) {
                set.add(item);
            } else {
                if (set.contains(item.substring(0, item.length() - 1))) {
                    set.add(item);
                }
            }
        }
        int maxLength = 0;
        for (String word : set) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }
        List<String> targetList = new ArrayList<>();
        for (String word : set) {
            if (word.length() == maxLength) {
                targetList.add(word);
            }
        }
        targetList.sort(String::compareTo);
        return targetList.isEmpty() ? "" : targetList.get(0);
    }

    public static void main(String[] args) {
        LongestWord longestWord = new LongestWord();
        System.out.println(longestWord.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }
}
