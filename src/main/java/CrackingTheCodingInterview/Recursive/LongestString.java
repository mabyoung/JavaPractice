package CrackingTheCodingInterview.Recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestString {
    public int getLongest(String[] str, int n) {
        List<String> list = new ArrayList<>(Arrays.asList(str));
        list.remove(0);
        list.sort((o1, o2) -> o2.length() - o1.length());
        for (int i = 0; i < list.size(); i++) {
            if (isTheRightOne(list, i, list.get(i))) {
                return list.get(i).length();
            }
        }
        return -1;
    }

    private boolean isTheRightOne(List<String> list, int index, String targetStr) {
        if (targetStr == null || targetStr.length() == 0) {
            return true;
        }
        for (int i = index + 1; i < list.size(); i++) {
            if (targetStr.startsWith(list.get(i))) {
                return isTheRightOne(list, index, targetStr.substring(list.get(i).length()));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LongestString longestString = new LongestString();
        int result = longestString.getLongest(new String[]{"a", "b", "c", "ab", "bc", "abc"}, 6);
        System.out.println(result);
    }
}
