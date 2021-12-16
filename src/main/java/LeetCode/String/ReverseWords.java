package LeetCode.String;

import java.util.StringJoiner;

public class ReverseWords {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (String word : words) {
            StringBuilder stringBuilder = new StringBuilder(word);
            stringJoiner.add(stringBuilder.reverse());
        }
        return stringJoiner.toString();
    }

}
