package LeetCode.String;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class ToGoatLatin {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringJoiner stringJoiner = new StringJoiner(" ");
        List<Character> characterList = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        for (int i = 0; i < words.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            if (characterList.contains(words[i].charAt(0))) {
                stringBuilder.append(words[i]);
            } else {
                stringBuilder.append(words[i].substring(1)).append(words[i].charAt(0));
            }
            stringBuilder.append("ma");
            for (int j = 0; j <= i; j++) {
                stringBuilder.append("a");
            }
            stringJoiner.add(stringBuilder);
        }
        return stringJoiner.toString();
    }
}
