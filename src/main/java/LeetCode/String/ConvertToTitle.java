package LeetCode.String;

import java.util.ArrayList;
import java.util.List;

public class ConvertToTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        while (columnNumber != 0) {
            stringBuilder.append((char) (--columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        ConvertToTitle convertToTitle = new ConvertToTitle();
        for (int i = 1; i < 100; i++) {
            System.out.println(convertToTitle.convertToTitle(i));
        }
    }
}
