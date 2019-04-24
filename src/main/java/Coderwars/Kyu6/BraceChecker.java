package Coderwars.Kyu6;

import java.util.Stack;

public class BraceChecker {
    public boolean isValid(String braces) {
        char[] chars = braces.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (stack.isEmpty()){
                stack.push(aChar);
            } else if (aChar == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (aChar == ']' && stack.peek() == '['){
                stack.pop();
            } else if (aChar == '}' && stack.peek() == '{'){
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        BraceChecker braceChecker = new BraceChecker();
        System.out.println(braceChecker.isValid("[(])"));
    }
}
