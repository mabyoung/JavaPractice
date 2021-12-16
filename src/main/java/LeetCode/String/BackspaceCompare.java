package LeetCode.String;

import java.util.LinkedList;

public class BackspaceCompare {
    public boolean backspaceCompare(String s, String t) {
        return getFinalString(s).equals(getFinalString(t));
    }

    public String getFinalString(String str) {
        LinkedList<Character> linkedList = new LinkedList<>();
        for (char c : str.toCharArray()) {
            if (c == '#' && !linkedList.isEmpty()) {
                linkedList.removeLast();
            } else if (c != '#'){
                linkedList.addLast(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character item : linkedList) {
            stringBuilder.append(item);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        BackspaceCompare backspaceCompare = new BackspaceCompare();
        System.out.println(backspaceCompare.getFinalString("y#f#o##f"));
    }
}
