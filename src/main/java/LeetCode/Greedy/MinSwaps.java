package LeetCode.Greedy;

import java.util.LinkedList;

public class MinSwaps {
    public int minSwaps(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        LinkedList<Character> linkedList = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == ']' && !linkedList.isEmpty() && linkedList.getLast() == '[') {
                linkedList.pollLast();
            } else {
                linkedList.addLast(c);
            }
        }
        return (linkedList.size() + 3) / 4;
    }
}
