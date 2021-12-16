package LeetCode.String;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ReverseParentheses {
    public String reverseParentheses(String s) {
        LinkedList<Character> linkedList = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == ')') {
                List<Character> list = new ArrayList<>();
                char current;
                while ((current = linkedList.pollLast()) != '(') {
                    list.add(current);
                }
                for (Character character : list) {
                    linkedList.addLast(character);
                }
            } else {
                linkedList.addLast(aChar);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : linkedList) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        ReverseParentheses reverseParentheses = new ReverseParentheses();
        String result = reverseParentheses.reverseParentheses("(u(love)i)");
        System.out.println(result);
    }
}
