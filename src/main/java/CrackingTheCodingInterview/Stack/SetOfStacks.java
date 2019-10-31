package CrackingTheCodingInterview.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 请实现一种数据结构SetOfStacks，由多个栈组成，其中每个栈的大小为size，当前一个栈填满时，新建一个栈。该数据结构应支持与普通栈相同的push和pop操作。
 * 给定一个操作序列int[][2] ope(C++为vector&ltvector&ltint>>)，每个操作的第一个数代表操作类型，若为1，则为push操作，后一个数为应push的数字；
 * 若为2，则为pop操作，后一个数无意义。请返回一个int[][](C++为vector&ltvector&ltint>>)，为完成所有操作后的SetOfStacks，顺序应为从下到上，
 * 默认初始的SetOfStacks为空。保证数据合法。
 */
public class SetOfStacks {
    public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
        List<Stack<Integer>> stackList = new ArrayList<>();
        stackList.add(new Stack<>());
        for (int[] item : ope) {
            Stack<Integer> stack = stackList.get(stackList.size() - 1);
            if (item[0] == 1) {
                if (stack.size() == size) {
                    stack = new Stack<>();
                    stackList.add(stack);
                }
                stack.push(item[1]);
            } else if (item[0] == 2) {
                if (stack.isEmpty()) {
                    stackList.remove(stackList.size() - 1);
                    stack = stackList.get(stackList.size() - 1);
                }
                stack.pop();
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (Stack<Integer> stack : stackList) {
            ArrayList<Integer> tmp = new ArrayList<>();
            while (!stack.isEmpty()) {
                tmp.add(0, stack.pop());
            }
            result.add(tmp);
        }
        return result;
    }
}
