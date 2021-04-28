package OldExams2016.Greedy;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * 题目描述
 * 现在有一张半径为r的圆桌，其中心位于(x,y)，现在他想把圆桌的中心移到(x1,y1)。每次移动一步，都必须在圆桌边缘固定一个点然后将圆桌绕这个点旋转。问最少需要移动几步。
 * 输入描述:
 * 一行五个整数r,x,y,x1,y1(1≤r≤100000,-100000≤x,y,x1,y1≤100000)
 * 输出描述:
 * 输出一个整数，表示答案
 */
public class MovingRoundTable {
    public static BigDecimal sqrt(BigDecimal value, int scale) {
        BigDecimal num2 = BigDecimal.valueOf(2);
        int precision = 100;
        MathContext mc = new MathContext(precision, RoundingMode.HALF_UP);
        BigDecimal deviation = value;
        int cnt = 0;
        while (cnt < precision) {
            deviation = (deviation.add(value.divide(deviation, mc))).divide(num2, mc);
            cnt++;
        }
        return deviation.setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    public static int getMinMoveTime(int r, int x, int y, int x1, int y1) {
        BigDecimal xDistance = new BigDecimal(x1 - x);
        BigDecimal yDistance = new BigDecimal(y1 - y);
        double distance = sqrt(xDistance.multiply(xDistance).add(yDistance.multiply(yDistance)), 2).doubleValue();
        return (int) distance / (2 * r);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int r = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            System.out.println(getMinMoveTime(r, x, y, x1, y1));
        }
    }


}
