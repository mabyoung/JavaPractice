package SwordOffer.StackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInWindows {
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (size <= 0 || num == null || num.length <= 0 || size > num.length) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!queue.isEmpty() && num[i] > num[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.peekFirst() <= i - size) {
                queue.pollFirst();
            }
            if (i>=size-1){
                result.add(num[queue.peekFirst()]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> integers = maxInWindows(num, 0);
        for (Integer integer : integers) {
            System.out.print(integer);
        }
    }
}
