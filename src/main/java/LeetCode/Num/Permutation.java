package LeetCode.Num;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {
    public String[] permutation(String s) {
        List<String> list = new ArrayList<>(Collections.singletonList(s));
        char[] chars = s.toCharArray();
        char[] item = getNext(chars);
        while (!new String(item).equals(s)) {
            list.add(new String(item));
            item = getNext(item);
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public char[] getNext(char[] chars) {
        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[i] < chars[i + 1]) {
                int j = i + 1;
                while (j < chars.length && chars[j] > chars[i]) {
                    j++;
                }
                char tmp = chars[i];
                chars[i] = chars[j - 1];
                chars[j - 1] = tmp;
                return revert(chars, i + 1, chars.length - 1);
            }
        }
        return revert(chars, 0, chars.length - 1);
    }

    public char[] revert(char[] chars, int left, int right) {
        while (left <= right) {
            char tmp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }
        return chars;
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        String[] result = permutation.permutation("312343");
        for (String item : result) {
            System.out.println(item);
        }
    }
}
