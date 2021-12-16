package LeetCode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        List<Character> licenseList = new ArrayList<>();
        for (char license : licensePlate.toLowerCase().toCharArray()) {
            if (license >= 'a' && license <= 'z') {
                licenseList.add(license);
            }
        }
        Collections.sort(licenseList);
        String result = null;
        for (String word : words) {
            if (isOk(licenseList, word) && (result == null || word.length() < result.length())) {
                result = word;
            }
        }
        return result;
    }

    public boolean isOk(List<Character> licenseList, String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        int index1 = 0;
        int index2 = 0;
        while (index1 < licenseList.size() && index2 < chars.length) {
            if (licenseList.get(index1) == chars[index2]) {
                index1++;
                index2++;
            } else {
                index2++;
            }
        }
        return index1 == licenseList.size();
    }
}
