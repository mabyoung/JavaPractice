package LeetCode.String;

import java.util.ArrayList;

public class TextJustification {
    public ArrayList<String> fullJustify(String[] words, int L) {
        if (L == 0){
            ArrayList<String> result = new ArrayList<>();
            result.add("");
            return result;
        }
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> current = new ArrayList<>();
        int currentLength = 0;
        for (String word : words) {
            if (word.length() + currentLength + 1 < L) {
                current.add(word);
                currentLength += word.length();
            } else {
                int spaceNum = L - currentLength;
                int averageSpaceNum = spaceNum / (current.size() - 1);
                int extraSpaceNum = spaceNum - averageSpaceNum * (current.size() - 1);
                StringBuilder stringBuilder = new StringBuilder();
                for (String s : current) {
                    stringBuilder.append(s);
                    for (int i = 0; i < averageSpaceNum; i++) {
                        stringBuilder.append(" ");
                    }
                    if (extraSpaceNum > 0) {
                        stringBuilder.append(" ");
                        extraSpaceNum--;
                    }
                }
                result.add(stringBuilder.toString().trim());
                current = new ArrayList<>();
                current.add(word);
                currentLength = word.length();
            }
        }
        if (currentLength >= 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : current) {
                stringBuilder.append(s);
            }
            result.add(stringBuilder.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        TextJustification textJustification = new TextJustification();
        ArrayList<String> result = textJustification.fullJustify(new String[]{""}, 0);
        System.out.println(result);
    }
}
