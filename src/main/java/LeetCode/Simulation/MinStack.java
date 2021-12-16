package LeetCode.Simulation;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        stack1.push(val);
        if (stack2.isEmpty()) {
            stack2.push(val);
        } else {
            stack2.push(Math.min(val, stack2.peek()));
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
