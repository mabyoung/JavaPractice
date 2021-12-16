package LeetCode.String;

import java.util.*;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        Set<String> bannedWordSet = new HashSet<>(Arrays.asList(banned));
        for (String word : dealParagraph(paragraph)) {
            if (!bannedWordSet.contains(word)) {
                wordFrequencyMap.merge(word, 1, Integer::sum);
            }
        }
        int maxFrequency = 0;
        String result = null;
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    public List<String> dealParagraph(String paragraph) {
        List<String> result = new ArrayList<>();
        int index = 0;
        paragraph = paragraph.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        while (index < paragraph.length()) {
            if (paragraph.charAt(index) >= 'a' && paragraph.charAt(index) <= 'z') {
                stringBuilder.append(paragraph.charAt(index));
            } else if (stringBuilder.length() > 0) {
                result.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }
            index++;
        }
        if (stringBuilder.length() > 0) {
            result.add(stringBuilder.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        MostCommonWord mostCommonWord = new MostCommonWord();
        String result = mostCommonWord.mostCommonWord("Bob. hIt, baLl", new String[]{"hit", "bob"});
        System.out.println(result);
    }
}
