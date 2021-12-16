package LeetCode;

public class SortSentence {
    public String sortSentence(String s) {
        String[] sentences = s.split(" ");
        String[] sortedSentences = new String[sentences.length];
        for (String sentence : sentences) {
            int numIndex = getNumIndex(sentence);
            sortedSentences[Integer.parseInt(sentence.substring(numIndex)) - 1] = sentence.substring(0, numIndex);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String sortedSentence : sortedSentences) {
            stringBuilder.append(sortedSentence).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public int getNumIndex(String sentence) {
        char[] chars = sentence.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SortSentence sortSentence = new SortSentence();
        String result = sortSentence.sortSentence("Myself2 Me1 I4 and3");
        System.out.println(result);
    }
}
