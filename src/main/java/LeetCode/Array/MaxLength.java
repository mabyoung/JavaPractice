package LeetCode.Array;

import java.util.*;

public class MaxLength {
    private int result = 0;

    public int maxLength(List<String> arr) {
        maxLength(arr, 0, "");
        return result;
    }

    public void maxLength(List<String> arr, int index, String currentStr) {
        result = Math.max(result, currentStr.length());
        if (index == arr.size()) {
            return;
        }
        maxLength(arr, index + 1, currentStr);
        if (!haveSameChar(currentStr + arr.get(index))){
            maxLength(arr, index + 1, currentStr + arr.get(index));
        }
    }

    public boolean haveSameChar(String str) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (set.contains(c)) {
                return true;
            }
            set.add(c);
        }
        return false;
    }

    public static void main(String[] args) {
        MaxLength maxLength = new MaxLength();
        List<String> list = new ArrayList<>();
        list.add("bkhwmpbiisbldzknpm");
        list.add("u");
        int result = maxLength.maxLength(list);
        System.out.println(result);
    }
}
