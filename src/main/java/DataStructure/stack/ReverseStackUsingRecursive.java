package DataStructure.stack;

import java.util.Stack;

public class ReverseStackUsingRecursive {
    public static int getAndRemoveLast(Stack<Integer> stack){
        Integer pop = stack.pop();
        if (stack.isEmpty()){
            return pop;
        }
        int last = getAndRemoveLast(stack);
        stack.push(pop);
        return last;
    }

    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int last = getAndRemoveLast(stack);
        reverse(stack);
        stack.push(last);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        reverse(stack);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
