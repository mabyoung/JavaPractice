package LeetCode.Simulation;

public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    result = Math.max(result, countArea(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]));
                }
            }
        }
        return result;
    }

    public double countArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double a = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        double b = Math.sqrt((x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1));
        double c = Math.sqrt((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2));
        double tmp = (a + b + c) * (a + b - c) * (a + c - b) * (b + c - a);
        if (tmp - 0 < 0.0000001) {
            return 0;
        }
        return 0.25 * Math.sqrt(tmp);
    }

    public static void main(String[] args) {
        LargestTriangleArea largestTriangleArea = new LargestTriangleArea();
        System.out.println(largestTriangleArea.largestTriangleArea(new int[][]{{35, -23}, {-12, -48}, {-34, -40}, {21, -25}, {-35, -44}, {24, 1}, {16, -9}, {41, 4}, {-36, -49}, {42, -49}, {-37, -20}, {-35, 11}, {-2, -36}, {18, 21}, {18, 8}, {-24, 14}, {-23, -11}, {-8, 44}, {-19, -3}, {0, -10}, {-21, -4}, {23, 18}, {20, 11}, {-42, 24}, {6, -19}}));
    }
}
