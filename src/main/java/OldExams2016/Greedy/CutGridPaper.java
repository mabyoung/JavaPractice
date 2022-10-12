package OldExams2016.Greedy;

import java.util.Scanner;

/**
 * 度度熊有一张网格纸，但是纸上有一些点过的点，每个点都在网格点上，若把网格看成一个坐标轴平行于网格线的坐标系的话，
 * 每个点可以用一对整数x，y来表示。度度熊必须沿着网格线画一个正方形，使所有点在正方形的内部或者边界。然后把这个正方形剪下来。
 * 问剪掉正方形的最小面积是多少。
 * 输入描述:
 * 第一行一个数n(2≤n≤1000)表示点数，接下来每行一对整数xi,yi(－1e9<=xi,yi<=1e9)表示网格上的点
 * 输出描述:
 * 一行输出最小面积
 */
public class CutGridPaper {
    public static int getMinArea(int[][] points) {
        int maxX = 0, maxY = 0, minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for (int[] point : points) {
            maxX = Math.max(maxX, point[0]);
            maxY = Math.max(maxY, point[1]);
            minX = Math.min(minX, point[0]);
            minY = Math.min(minY, point[1]);
        }
        int minSide = Math.max(maxX - minX, maxY - minY);
        return minSide * minSide;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[][] points = new int[n][2];
            for (int i = 0; i < n; i++) {
                points[i][0] = scanner.nextInt();
                points[i][1] = scanner.nextInt();
            }
            System.out.println(getMinArea(points));
        }
    }
}