package LeetCode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargeGroupPositions {
    public List<List<Integer>> largeGroupPositions(String s) {
        char lastChar = s.charAt(0);
        int count = 1;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == lastChar) {
                count++;
            } else {
                if (count >= 3) {
                    List<Integer> list = Arrays.asList(i - count, i - 1);
                    result.add(list);
                }
                lastChar = s.charAt(i);
                count = 1;
            }
        }
        if (count >= 3) {
            List<Integer> list = Arrays.asList(s.length() - count, s.length() - 1);
            result.add(list);
        }
        return result;
    }
}
