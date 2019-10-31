package CrackingTheCodingInterview.Stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 * 给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到最后一个元素。
 */
public class TwoStacks {
    public ArrayList<Integer> twoStackSort(int[] numbers) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = numbers.length - 1; i >= 0; i--) {
            stack.push(numbers[i]);
        }
        Stack<Integer> tmpStack = new Stack<>();
        while (!stack.isEmpty()) {
            Integer tmp = stack.pop();
            int count = 0;
            while (!tmpStack.isEmpty() && tmp < tmpStack.peek()) {
                stack.push(tmpStack.pop());
                count++;
            }
            tmpStack.push(tmp);
            while (count > 0) {
                tmpStack.push(stack.pop());
                count--;
            }
        }
        while (!tmpStack.isEmpty()) {
            result.add(tmpStack.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        TwoStacks twoStacks = new TwoStacks();
        ArrayList<Integer> result = twoStacks.twoStackSort(new int[]{3, 5, 2, 6, 1});
        System.out.println(result);
    }
}
