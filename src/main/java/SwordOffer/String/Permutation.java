package SwordOffer.String;

import java.util.ArrayList;

public class Permutation {
    public ArrayList<String> permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        result.add(str);
        String next = getNext(str);
        while (!str.equals(next)) {
            result.add(next);
            next = getNext(next);
        }
        return result;
    }

    private String getNext(String str) {
        char[] chars = str.toCharArray();
        int i = chars.length - 2;
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }
        if (i == -1) {
            reverse(chars, 0, chars.length - 1);
            return new String(chars);
        }
        int j = i + 1;
        while (j < chars.length && chars[j] > chars[i]) {
            j++;
        }
        char tmp = chars[i];
        chars[i] = chars[j - 1];
        chars[j - 1] = tmp;
        reverse(chars, i + 1, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int begin, int end) {
        while (begin < end) {
            char tmp = chars[begin];
            chars[begin++] = chars[end];
            chars[end--] = tmp;
        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        ArrayList<String> result = permutation.permutation("abbc");
        for (String item : result) {
            System.out.println(item);
        }
    }
}
