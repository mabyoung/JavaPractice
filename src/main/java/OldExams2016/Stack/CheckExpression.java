package OldExams2016.Stack;

import java.util.Stack;

public class CheckExpression {
    public boolean chkLegal(String A) {
        Stack<Character> stack = new Stack<>();
        for (char item : A.toCharArray()) {
            switch (item) {
                case '{':
                case '[':
                case '(':
                    stack.push(item);
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        CheckExpression checkExpression = new CheckExpression();
        System.out.println(checkExpression.chkLegal("[a+b*(5-4)]*{x+b+b*({1+2)}}"));
        System.out.println(checkExpression.chkLegal("q*c*k+r-w-{f-e*c+f}"));
        System.out.println(checkExpression.chkLegal("g+{p+z-v"));
    }
}
