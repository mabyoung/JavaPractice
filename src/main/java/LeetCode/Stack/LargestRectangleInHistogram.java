package LeetCode.Stack;

import java.util.Stack;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/e3f491c56b7747539b93e5704b6eca40
 * 来源：牛客网
 *
 * 目的：用height[]构造一个升序栈,构造过程中计算面积；
 * 如果当前height[i]大于栈顶元素，则入栈；
 * 若小于栈顶元素，则将栈顶元素弹出并做记录弹出几次，并计算以弹出元素作为高度的面积，留下
 * 最大值ret，直到满足height[i]大于栈顶元素，再将弹出的元素以height[i]重新入栈；
 *     过程为 ：
 *     1）2入栈；目前栈为{2}
 *     2）1与2比较，不满足升序，则2弹出，记录count=1；ret=2*1；
 *        1代替2再次入栈，然后当前1入栈；目前栈为{1,1}
 *     3）5入栈，满足升序，6入栈满足升序；目前栈为{1,1,5,6,}
 *     4）height[4]=2，即将入栈，由于2小于栈顶元素6，则6弹出，count=1，ret=max（2,6）=6；
 *        2小于5,5弹出，count=2,ret=max(6,2*5)=10;
 *        6和5 重新以2入栈，然后height[4]=2入栈；
 *        目前栈为{1,1,2,2,2}
 *     5）height[5]=3入栈；形成升序栈{1,1,2,2,2,3}
 *     6）最后按照升序栈继续维护ret直至栈为空，max(ret,3*1,2*2,2*3,2*4*,1*5,1*6)=10;
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int item : height) {
            int count = 0;
            while (!stack.isEmpty() && item < stack.peek()) {
                Integer pop = stack.pop();
                count++;
                result = Integer.max(pop * count, result);
            }
            for (int i = 0; i < count; i++) {
                stack.push(item);
            }
            stack.push(item);
        }
        int count = 0;
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            count++;
            result = Integer.max(pop * count, result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1};
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        int result = largestRectangleInHistogram.largestRectangleArea(height);
        System.out.println(result);
    }
}
