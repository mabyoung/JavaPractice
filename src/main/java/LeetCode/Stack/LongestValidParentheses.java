package LeetCode.Stack;

import java.util.Stack;

/**
 * Given a string containing just the characters'('and')', find the length of the longest valid (well-formed) parentheses substring.
 * For"(()", the longest valid parentheses substring is"()", which has length = 2.
 * Another example is")()())", where the longest valid parentheses substring is"()()", which has length = 4.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int last = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    last = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        result = Math.max(result, i - last);
                    } else {
                        result = Math.max(result, i - stack.peek());
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        int result = longestValidParentheses.longestValidParentheses("()()");
        System.out.println(result);
    }
}
