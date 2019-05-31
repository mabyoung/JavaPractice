package LeetCode.Stack;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                Integer b = Integer.parseInt(stack.pop());
                Integer a = Integer.parseInt(stack.pop());
                int c = 0;
                switch (token) {
                    case "+": {
                        c = a + b;
                        break;
                    }
                    case "-": {
                        c = a - b;
                        break;
                    }
                    case "*": {
                        c = a * b;
                        break;
                    }
                    default: {
                        c = a / b;
                        break;
                    }
                }
                stack.push(Integer.toString(c));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        String[] a = {"2", "1", "+", "3", "*"};
        String[] b = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(b));
    }
}
