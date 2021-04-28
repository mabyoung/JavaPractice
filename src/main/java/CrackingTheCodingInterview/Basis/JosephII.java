package CrackingTheCodingInterview.Basis;

import java.util.ArrayList;
import java.util.List;

/**
 * 约瑟夫问题是一个著名的趣题。这里我们稍稍修改一下规则。有n个人站成一列。并从头到尾给他们编号，第一个人编号为1。
 * 然后从头开始报数，第一轮依次报1，2，1，2...然后报到2的人出局。接着第二轮再从上一轮最后一个报数的人开始依次报1，2，3，1，2，3...报到2，3的人出局。以此类推直到剩下以后一个人。现在需要求的即是这个人的编号。
 * 给定一个int n，代表游戏的人数。请返回最后一个人的编号
 */
public class JosephII {
    public int getResult(int n) {
        List<Integer> people = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }
        int m = 2;
        while (people.size() > 1) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < people.size(); i += m) {
                tmp.add(people.get(i));
            }
            tmp.add(0, tmp.get(tmp.size() - 1));
            tmp.remove(tmp.size() - 1);
            people = tmp;
            m++;
        }
        return people.get(0);
    }

    public static void main(String[] args) {
        JosephII josephII = new JosephII();
        System.out.println(josephII.getResult(5));
    }
}
