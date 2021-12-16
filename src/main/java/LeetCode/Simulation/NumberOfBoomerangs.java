package LeetCode.Simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfBoomerangs {
    public class Point {
        int x;
        int y;
    }

    public int numberOfBoomerangs(int[][] points) {
        List<Point> pointList = new ArrayList<>();
        for (int[] point : points) {
            Point tmp = new Point();
            tmp.x = point[0];
            tmp.y = point[1];
            pointList.add(tmp);
        }
        int result = 0;
        for (int i = 0; i < pointList.size(); i++) {
            result += countSameDistance(pointList, i);
        }
        return result;
    }

    public int countSameDistance(List<Point> pointList, int curIndex) {
        Point point = pointList.get(curIndex);
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < pointList.size(); i++) {
            if (i == curIndex) {
                continue;
            }
            long distance = getDistance(point, pointList.get(i));
            map.merge(distance, 1, Integer::sum);
        }
        int result = 0;
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            result += entry.getValue() * (entry.getValue() - 1);
        }
        return result;
    }

    public long getDistance(Point pointA, Point pointB) {
        long a = pointA.x - pointB.x;
        long b = pointA.y - pointB.y;
        return a * a + b * b;
    }
}
