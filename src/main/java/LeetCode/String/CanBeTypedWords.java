package LeetCode.String;

import java.util.HashSet;
import java.util.Set;

public class CanBeTypedWords {
    public int canBeTypedWords(String text, String brokenLetters) {
        char[] chars = brokenLetters.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char aChar : chars) {
            set.add(aChar);
        }
        int result = 0;
        for (String word : text.split(" ")) {
            if (isOk(word, set)) {
                result++;
            }
        }
        return result;
    }

    public boolean isOk(String word, Set<Character> set) {
        for (char c : word.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
        }
        return true;
    }
}
