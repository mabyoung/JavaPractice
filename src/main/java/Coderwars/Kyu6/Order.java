package Coderwars.Kyu6;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public static String order(String words) {
        if (words == null || words.equalsIgnoreCase("")) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        String[] wordList = words.split(" ");
        String[] wordsAfter = new String[10];
        for (String s : wordList) {
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                int item = aChar - '0';
                if (item >= 1 && item <= 9) {
                    wordsAfter[item - 1] = s;
                }
            }
        }
        for (String s : wordsAfter) {
            if (s != null && !s.equalsIgnoreCase("")) {
                result.append(" ").append(s);
            }
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(order("is2 Thi1s T4est 3a"));
    }
}
