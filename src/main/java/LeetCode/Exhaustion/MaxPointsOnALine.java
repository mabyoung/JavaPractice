package LeetCode.Exhaustion;

import java.util.*;

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}

public class MaxPointsOnALine {

    public int maxPoints(Point[] points) {
        if (points.length == 0){
            return 0;
        }
        int maxAll = 0;
        for (int i = 0; i < points.length; i++) {
            int count = 0;
            int maxX = 0;
            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j){
                    if (points[i].x == points[j].x && points[i].y == points[j].y) {
                        count++;
                    }else{
                        int yDifference = points[j].y-points[i].y;
                        int xDifference = points[j].x-points[i].x;
                        double gradient = (double)yDifference/xDifference;
                        if (map.containsKey(gradient)){
                            int value = map.get(gradient);
                            map.put(gradient, value+1);
                        }else{
                            map.put(gradient, 1);
                        }
                    }
                }
            }
            for (Map.Entry<Double, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxX){
                    maxX = entry.getValue();
                }
            }
            maxX +=  count;
            if (maxX > maxAll){
                maxAll = maxX;
            }
        }
        return maxAll + 1;
    }

    public static void main(String[] args) {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(1, -1);
        Point point3 = new Point(1, 1);
        Point[] pointArray = new Point[]{point1, point2, point3};
        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();
        System.out.println(maxPointsOnALine.maxPoints(pointArray));
    }
}
