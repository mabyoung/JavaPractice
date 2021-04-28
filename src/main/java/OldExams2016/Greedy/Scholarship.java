package OldExams2016.Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 小v今年有n门课，每门都有考试，为了拿到奖学金，小v必须让自己的平均成绩至少为avg。每门课由平时成绩和考试成绩组成，满分为r。现在他知道每门课的平时成绩为ai ,若想让这门课的考试成绩多拿一分的话，小v要花bi 的时间复习，不复习的话当然就是0分。同时我们显然可以发现复习得再多也不会拿到超过满分的分数。为了拿到奖学金，小v至少要花多少时间复习。
 * 输入描述:
 * 第一行三个整数n,r,avg(n大于等于1小于等于1e5，r大于等于1小于等于1e9,avg大于等于1小于等于1e6)，接下来n行，每行两个整数ai和bi，均小于等于1e6大于等于1
 * 输出描述:
 * 一行输出答案。
 * 示例1
 * 输入
 * 复制
 * 5 10 9
 * 0 5
 * 9 1
 * 8 1
 * 0 1
 * 9 100
 * 输出
 * 复制
 * 43
 */
public class Scholarship {
    public static class ScoreWithTime {
        int score;
        int time;

        ScoreWithTime(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    public static long getReviewTime(int r, int avg, int[] a, int[] b) {
        List<ScoreWithTime> list = new ArrayList<>();
        int targetScore = avg * a.length;
        int nowScore = 0;
        long result = 0;
        for (int i = 0; i < a.length; i++) {
            nowScore += a[i];
            ScoreWithTime scoreWithTime = new ScoreWithTime(a[i], b[i]);
            list.add(scoreWithTime);
        }
        if (nowScore >= targetScore){
            return 0;
        }
        list.sort(Comparator.comparingInt(o -> o.time));
        for (ScoreWithTime scoreWithTime : list) {
            if (r - scoreWithTime.score + nowScore >= targetScore) {
                result += scoreWithTime.time * (targetScore - nowScore);
                return result;
            } else {
                result += scoreWithTime.time * (r - scoreWithTime.score);
                nowScore += (r - scoreWithTime.score);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int r = scanner.nextInt();
            int avg = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                b[i] = scanner.nextInt();
            }
            System.out.println(getReviewTime(r, avg, a, b));
        }
    }
}
