package CrackingTheCodingInterview.Stack;

import java.util.Stack;

public class NextElement {
    public int[] findNext(int[] A, int n) {
        int[] result = new int[A.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = A.length - 1; i >= 0; i--) {
            result[i] = getFirstNumBiggerThanTargetInStack(stack, A[i]);
            while (!stack.isEmpty() && stack.peek() < A[i]) {
                stack.pop();
            }
            stack.push(A[i]);
        }
        return result;
    }

    private int getFirstNumBiggerThanTargetInStack(Stack<Integer> stack, int target) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            if (stack.get(i) > target) {
                return stack.get(i);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        NextElement nextElement = new NextElement();
        int[] result = nextElement.findNext(new int[]{11, 13, 10, 5, 12, 21, 3}, 7);
        for (int item : result) {
            System.out.println(item);
        }
    }
}
