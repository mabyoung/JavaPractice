package Company.ThoughtWorks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Word {
    String content;
    int startLine;
    int endLine;
}

public class TextProcessor {
    private void buildWord(LinkedList<Character> queue, List<Word> wordList, int start, int index, int width) {
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.pollFirst());
        }
        Word word = new Word();
        word.content = sb.toString();
        word.startLine = start;
        word.endLine = (index - 1) / width;
        wordList.add(word);
    }

    public String process(String text, int width) {
        if (width < 10 || width > 80) {
            return "ERROR: Width out of range!";
        }
        char[] chars = text.toCharArray();
        List<Word> wordList = new ArrayList<>();
        int index = 0;
        int start = 0;
        LinkedList<Character> queue = new LinkedList<>();
        for (char aChar : chars) {
            if (!(aChar >= 'a' && aChar <= 'z' || aChar >= 'A' && aChar <= 'Z' || aChar == ' ')) {
                return "ERROR: Invalid character detected!";
            }
            if (aChar == ' ' && !queue.isEmpty() && queue.getLast() != ' '
                    || aChar != ' ' && !queue.isEmpty() && queue.getLast() == ' ') {
                buildWord(queue, wordList, start, index, width);
            }
            if (queue.isEmpty()) {
                start = index / width;
            }
            queue.addLast(aChar);
            index++;
        }
        if (!queue.isEmpty()) {
            buildWord(queue, wordList, start, index, width);
        }
        StringBuilder result = new StringBuilder();
        for (Word word : wordList) {
            result.append(word.content).append("(").append(word.startLine + 1);
            if (word.endLine != word.startLine) {
                result.append(",").append(word.endLine + 1);
            }
            result.append(")").append(";");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String text = "The main theme of education in engineering school is learning to teach yourself";
        TextProcessor textProcessor = new TextProcessor();
        System.out.println(textProcessor.process(text, 30));
    }
}