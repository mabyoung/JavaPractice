package tiba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 实现一个特殊功能的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * 其中1代表push，2代表pop，3代表获取栈中最小值
 */
public class MinStack {
    /**
     * return a array which include all ans for op3
     * @param op int整型二维数组 operator
     * @return int整型一维数组
     */
    public int[] getMinStack (int[][] op) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        for (int[] operators : op) {
            switch (operators[0]){
                case 1:
                    stack.push(operators[1]);
                    if (minStack.isEmpty()){
                        minStack.push(operators[1]);
                    }else {
                        minStack.push(Math.min(minStack.peek(), operators[1]));
                    }
                    break;
                case 2:
                    stack.pop();
                    minStack.pop();
                    break;
                case 3:
                    list.add(minStack.peek());
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        MinStack minStack  =new MinStack();
        int[] result = minStack.getMinStack(new int[][]{{1, 3}, {1, 2}, {1, 1}, {3}, {2}, {3}});
        System.out.println(Arrays.toString(result));
    }
}
