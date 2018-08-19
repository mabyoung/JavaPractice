package SwordOffer;

import java.util.Stack;

public class MinStack {
    public static Stack<Integer> stack = new Stack<>();
    public static Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (!minStack.isEmpty() && minStack.peek()<node){
            minStack.push(minStack.peek());
        }else{
            minStack.push(node);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
