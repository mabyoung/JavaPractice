package LeetCode.Stack;

import java.util.LinkedList;

public class CheckValidString {
    public boolean checkValidString(String s) {
        char[] chars = s.toCharArray();
        LinkedList<Character> linkedList = new LinkedList<>();
        for (char item : chars) {
            if (item != ')') {
                linkedList.addLast(item);
                continue;
            }
            int index = getFirst(linkedList);
            if (index == -1) {
                if (linkedList.isEmpty()) {
                    return false;
                } else {
                    linkedList.removeLast();
                }
            } else {
                if (linkedList.get(index) == '(') {
                    linkedList.remove(index);
                }
            }
        }
        while (!linkedList.isEmpty()) {
            if (linkedList.getLast() == '(' || linkedList.getLast() == ')') {
                return false;
            }
            int index = getFirst(linkedList);
            if (index == -1) {
                return true;
            }
            if (linkedList.get(index) == ')') {
                return false;
            }
            linkedList.remove(index);
            linkedList.removeLast();
        }
        return true;
    }

    public int getFirst(LinkedList<Character> linkedList) {
        for (int i = linkedList.size() - 1; i >= 0; i--) {
            if (linkedList.get(i) != '*') {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CheckValidString checkValidString = new CheckValidString();
        boolean result = checkValidString.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())");
        System.out.println(result);
    }
}
