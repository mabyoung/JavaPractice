package LeetCode.String;

import java.util.ArrayList;
import java.util.List;

public class ShortestToChar {
    private int cnt = 0;

    public int[] shortestToChar(String s, char c) {
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                indexList.add(i);
            }
        }
        Integer lastIndex = Integer.MAX_VALUE;
        Integer nextIndex = getNextIndex(indexList);
        int[] result = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = Math.min(Math.abs(lastIndex - i), Math.abs(nextIndex - i));
            if (nextIndex == i){
                lastIndex = nextIndex;
                nextIndex = getNextIndex(indexList);
            }
        }
        return result;
    }

    public Integer getNextIndex(List<Integer> indexList) {
        if (indexList.size() > cnt) {
            return indexList.get(cnt++);
        }
        return Integer.MAX_VALUE;
    }


}
