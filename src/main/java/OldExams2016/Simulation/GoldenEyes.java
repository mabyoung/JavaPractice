package OldExams2016.Simulation;

import javax.swing.*;
import java.util.*;

/**
 * 题目描述
 * 现在我们需要查出一些作弊的问答社区中的ID，作弊有两种：1.A回答了B的问题，同时B回答了A的问题。那么A和B都是作弊。2.作弊ID用户A和作弊ID用户B同时回答了C的问题，那么C也是作弊。已知每个用户的ID是一串数字，一个问题可能有多个人回答。
 * 输入描述:
 * 每组数据第一行为总问题数N(N小于等于200000)，第二行开始每行一个问题，第一个数字为提问人ID，第二个数字为回答人数，后面则为所有回答人的ID。(ID均为0-1000000的整数)
 * 输出描述:
 * 第一行为作弊ID数量，第二行开始为从小到大的每行一个作弊ID。
 * 示例1
 * 输入
 * 复制
 * 3
 * 1 1 2
 * 2 1 1
 * 3 2 1 2
 * 输出
 * 复制
 * 3
 * 1 2 3
 */
public class GoldenEyes {
    public static List<Integer> getCheaterIds(int[][] edges, int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (edges[i][j] == 1 && edges[j][i] == 1) {
                    if (!result.contains(i)){
                        result.add(i);
                    }
                    if (!result.contains(j)){
                        result.add(j);
                    }
                    for (int k = 1; k <= n; k++) {
                        if (!result.contains(k) && edges[k][i] == 1 && edges[k][j] == 1) {
                            result.add(k);
                        }
                    }
                }
            }
        }
        result.sort(Comparator.comparingInt(o -> o));
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] edges = new int[n + 1][n + 1];
            for (int i = 0; i < n; i++) {
                int questionerId = scanner.nextInt();
                int answerNum = scanner.nextInt();
                int[] answerIds = new int[answerNum];
                for (int j = 0; j < answerNum; j++) {
                    answerIds[j] = scanner.nextInt();
                }
                for (int answerId : answerIds) {
                    edges[questionerId][answerId] = 1;
                }
            }
            List<Integer> cheaterIds = getCheaterIds(edges, n);
            System.out.println(cheaterIds.size());
            for (int i = 0; i < cheaterIds.size(); i++) {
                System.out.print(cheaterIds.get(i));
                if (i != cheaterIds.size()-1){
                    System.out.print(" ");
                }else{
                    System.out.println();
                }
            }
        }
    }
}
