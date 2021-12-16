package LeetCode.Simulation;

import java.util.LinkedList;

public class MyStack {
    LinkedList<Integer> queueA;
    LinkedList<Integer> queueB;


    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queueA = new LinkedList<>();
        queueB = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queueA.addLast(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (queueA.size() > 1) {
            queueB.addLast(queueA.removeFirst());
        }
        int result = queueA.removeFirst();
        while (!queueB.isEmpty()) {
            queueA.addLast(queueB.removeFirst());
        }
        return result;
    }

    /**
     * Get the top element.
     */
    public int top() {
        while (queueA.size() > 1) {
            queueB.addLast(queueA.removeFirst());
        }
        int result = queueA.getFirst();
        queueB.addLast(queueA.removeFirst());
        while (!queueB.isEmpty()) {
            queueA.addLast(queueB.removeFirst());
        }
        return result;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queueA.isEmpty();
    }
}
