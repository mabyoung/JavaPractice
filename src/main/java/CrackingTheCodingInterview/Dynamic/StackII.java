package CrackingTheCodingInterview.Dynamic;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 叠罗汉是一个著名的游戏，游戏中一个人要站在另一个人的肩膀上。为了使叠成的罗汉更稳固，我们应该让上面的人比下面的人更轻一点。现在一个马戏团要表演这个节目，为了视觉效果，我们还要求下面的人的身高比上面的人高。请编写一个算法，计算最多能叠多少人，注意这里所有演员都同时出现。
 * 给定一个二维int的数组actors，每个元素有两个值，分别代表一个演员的身高和体重。同时给定演员总数n，请返回最多能叠的人数。保证总人数小于等于500。
 */
public class StackII {
    public int getHeight(int[][] actors, int n) {
        Arrays.sort(actors, Comparator.comparingInt(o -> o[0]));
        int result = 1;
        int[] maxNum = new int[n];
        maxNum[0] = 1;
        for (int i = 1; i < n; i++) {
            maxNum[i] = 1;
            for (int j = 0; j < i; j++) {
                if (actors[j][0] < actors[i][0] && actors[j][1] < actors[i][1] && maxNum[j] + 1 > maxNum[i]) {
                    maxNum[i] = maxNum[j] + 1;
                    result = Math.max(maxNum[i], result);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        StackII stackII = new StackII();
        System.out.println(stackII.getHeight(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}, 4));
    }
}
