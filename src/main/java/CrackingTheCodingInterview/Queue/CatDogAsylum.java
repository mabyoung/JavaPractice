package CrackingTheCodingInterview.Queue;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 有家动物收容所只收留猫和狗，但有特殊的收养规则，收养人有两种收养方式，第一种为直接收养所有动物中最早进入收容所的，第二种为选择收养的动物类型（猫或狗），并收养该种动物中最早进入收容所的。
 * <p>
 * 给定一个操作序列int[][2] ope(C++中为vector<vector<int>>)代表所有事件。若第一个元素为1，则代表有动物进入收容所，
 * 第二个元素为动物的编号，正数代表狗，负数代表猫；若第一个元素为2，则代表有人收养动物，第二个元素若为0，则采取第一种收养方式，若为1，
 * 则指定收养狗，若为-1则指定收养猫。请按顺序返回收养的序列。若出现不合法的操作，即没有可以符合领养要求的动物，则将这次领养操作忽略。
 */
public class CatDogAsylum {
    public ArrayList<Integer> asylum(int[][] ope) {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int[] ints : ope) {
            if (ints[0] == 1) {
                queue.addLast(ints[1]);
            } else if (ints[0] == 2) {
                if (ints[1] == 0) {
                    if (!queue.isEmpty()) {
                        result.add(queue.removeFirst());
                    }
                } else if (ints[1] == 1) {
                    for (int i = 0; i < queue.size(); i++) {
                        if (queue.get(i) > 0) {
                            result.add(queue.get(i));
                            queue.remove(i);
                            break;
                        }
                    }
                } else if (ints[1] == -1) {
                    for (int i = 0; i < queue.size(); i++) {
                        if (queue.get(i) < 0) {
                            result.add(queue.get(i));
                            queue.remove(i);
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CatDogAsylum catDogAsylum = new CatDogAsylum();
        ArrayList<Integer> result = catDogAsylum.asylum(new int[][]{{1,1},{1,-1},{2,0},{2,-1}});
        System.out.println(result);
    }
}
