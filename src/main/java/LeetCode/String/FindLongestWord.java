package LeetCode.String;

import java.util.Arrays;
import java.util.List;

public class FindLongestWord {
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o2.length() - o1.length();
        });
        for (String word : dictionary) {
            if (isSubSequence(s, word)) {
                return word;
            }
        }
        return "";
    }

    public boolean isSubSequence(String s, String word) {
        int indexA = 0;
        int indexB = 0;
        while (indexA < s.length() && indexB < word.length()) {
            if (s.charAt(indexA) == word.charAt(indexB)) {
                indexA++;
                indexB++;
            } else {
                indexA++;
            }
        }
        return indexB == word.length();
    }

    public static void main(String[] args) {
        FindLongestWord findLongestWord = new FindLongestWord();
        String result = findLongestWord.findLongestWord("aewfafwafjlwajflwajflwafj", Arrays.asList("apple", "ewaf", "awefawfwaf", "awef", "awefe", "ewafeffewafewf"));
        System.out.println(result);
    }
}
