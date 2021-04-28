package CrackingTheCodingInterview.String;

import java.util.*;

public class SortString {
    public ArrayList<String> sortStrings(String[] str, int n) {
        Map<String, String> map = new HashMap<>();
        for (String s : str) {
            String variant = this.convertToVariant(s);
            if (map.get(variant) == null || s.compareTo(map.get(variant)) < 0) {
                map.put(variant, s);
            }
        }
        ArrayList<String> result = new ArrayList<>(map.values());
        Collections.sort(result);
        return result;
    }

    private String convertToVariant(String originalString) {
        char[] chars = originalString.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        SortString sortString = new SortString();
        ArrayList<String> result = sortString.sortStrings(new String[]{"ab", "ba", "abc", "cba"}, 4);
        System.out.println(result);
    }
}
