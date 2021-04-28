package CrackingTheCodingInterview.Basis;

import java.util.*;

/**
 * 在二维平面上，有一些点，请找出经过点数最多的那条线。
 * 给定一个点集vector<point>p和点集的大小n,没有两个点的横坐标相等的情况,请返回一个vector<double>，代表经过点数最多的那条直线的斜率和截距。</double></point>
 */
public class DenseLine {
    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point() {
            this.x = 0;
            this.y = 0;
        }
    }

    public class SlopeAndIntercept {
        public double slope;
        public double intercept;

        public SlopeAndIntercept(double slope, double intercept) {
            this.slope = slope;
            this.intercept = intercept;
        }
    }

    public double[] getLine(Point[] p, int n) {
        Map<SlopeAndIntercept, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            for (int j = i+1; j < p.length; j++) {
                double slope = (p[j].y - p[i].y) * 1.0 / (p[j].x - p[i].x);
                double intercept = p[j].y - slope * p[j].x;
                SlopeAndIntercept slopeAndIntercept = new SlopeAndIntercept(slope, intercept);
                if (map.containsKey(slopeAndIntercept)) {
                    map.put(slopeAndIntercept, map.get(slopeAndIntercept) + 1);
                } else {
                    map.put(slopeAndIntercept, 1);
                }
            }
        }
        int max = 0;
        double[] result = new double[2];
        for (SlopeAndIntercept slopeAndIntercept : map.keySet()) {
            if (map.get(slopeAndIntercept) > max) {
                result[0] = slopeAndIntercept.slope;
                result[1] = slopeAndIntercept.intercept;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DenseLine denseLine = new DenseLine();
        double[] result = denseLine.getLine(new Point[]{new Point(0, 152), new Point(5, 6502), new Point(10, 12852), new Point(15, 19202)}, 4);
        System.out.println(result);
    }
}
