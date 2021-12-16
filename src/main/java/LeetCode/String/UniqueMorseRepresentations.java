package LeetCode.String;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseRepresentations {

    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char item : word.toCharArray()) {
                stringBuilder.append(codes[item - 'a']);
            }
            set.add(stringBuilder.toString());
        }
        return set.size();
    }
}
