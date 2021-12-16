package LeetCode.Stack;

import java.util.Stack;

public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c){
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        isValid.isValid("()");
    }
}
