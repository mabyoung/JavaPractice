package LeetCode.Num;

/**
 * 633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 */
public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        int maxSqrt = (int) Math.sqrt(c);
        for (int sqrt = 0; sqrt <= maxSqrt; sqrt++) {
            if (isSquareNum(c - sqrt * sqrt)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSquareNum(int c) {
        double sqrt = Math.sqrt(c);
        return sqrt == (int) sqrt;
    }

    public static void main(String[] args) {
        JudgeSquareSum judgeSquareSum = new JudgeSquareSum();
        System.out.println(judgeSquareSum.judgeSquareSum(2147483646));
    }
}
