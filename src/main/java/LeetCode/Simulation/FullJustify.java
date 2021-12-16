package LeetCode.Simulation;

import java.util.ArrayList;
import java.util.List;

public class FullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int length = 0;
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (length + words[i].length() + 1 > maxWidth + 1) {
                result.add(justify(wordList, maxWidth));
                wordList = new ArrayList<>();
                length = 0;
            }
            wordList.add(words[i]);
            length += words[i].length() + 1;
        }
        result.add(justifyEnd(wordList, maxWidth));
        return result;
    }

    public String justify(List<String> wordList, int maxWidth) {
        if (wordList.size() == 1) {
            return justifyEnd(wordList, maxWidth);
        }
        int totalLength = 0;
        for (String s : wordList) {
            totalLength += s.length();
        }
        int excessLength = maxWidth - totalLength;
        int a = excessLength / (wordList.size() - 1);
        int b = excessLength % (wordList.size() - 1);
        StringBuilder stringBuilder = new StringBuilder();
        List<String> spaceList = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < a; i++) {
            tmp.append(" ");
        }
        for (int i = 0; i < b; i++) {
            spaceList.add(tmp.toString() + " ");
        }
        for (int i = 0; i < wordList.size() - b - 1; i++) {
            spaceList.add(tmp.toString());
        }
        for (int i = 0; i < wordList.size() - 1; i++) {
            stringBuilder.append(wordList.get(i)).append(spaceList.get(i));
        }
        stringBuilder.append(wordList.get(wordList.size() - 1));
        return stringBuilder.toString();
    }

    public String justifyEnd(List<String> wordList, int maxWidth) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : wordList) {
            stringBuilder.append(s).append(" ");
        }
        if (stringBuilder.length() > maxWidth) {
            return stringBuilder.toString().trim();
        }
        while (stringBuilder.length() < maxWidth) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        FullJustify fullJustify = new FullJustify();
        List<String> result = fullJustify.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        System.out.println(result);
    }
}
