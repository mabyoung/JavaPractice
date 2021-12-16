package LeetCode.Simulation;

import java.util.HashMap;
import java.util.Map;

public class MaxPoints {
    public int maxPoints(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int y = points[j][1] - points[i][1];
                int x = points[j][0] - points[i][0];
                if (x != 0 && y != 0) {
                    if (y < 0) {
                        y = -y;
                        x = -x;
                    }
                    int greatestCommonDivisor = gcd(x, y);
                    y /= greatestCommonDivisor;
                    x /= greatestCommonDivisor;
                } else if (x == 0) {
                    y = 1;
                } else {
                    x = 1;
                }
                String key = y + "_" + x;
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
            }
            for (Integer value : map.values()) {
                if (value > result) {
                    result = value;
                }
            }
        }
        return result + 1;
    }

    public int gcd(int x, int y) {
        while (x != 0 && y != 0) {
            y = y % x;
            if (y != 0) {
                x = x % y;
            }
        }
        return x != 0 ? Math.abs(x) : Math.abs(y);
    }

    public static void main(String[] args) {
        MaxPoints maxPoints = new MaxPoints();
        int[][] points = new int[][]{{7,3},{19,19},{-16,3},{13,17},{-18,1},{-18,-17},{13,-3},{3,7},{-11,12},{7,19},{19,-12},{20,-18},{-16,-15},{-10,-15},{-16,-18},{-14,-1},{18,10},{-13,8},{7,-5},{-4,-9},{-11,2},{-9,-9},{-5,-16},{10,14},{-3,4},{1,-20},{2,16},{0,14},{-14,5},{15,-11},{3,11},{11,-10},{-1,-7},{16,7},{1,-11},{-8,-3},{1,-6},{19,7},{3,6},{-1,-2},{7,-3},{-6,-8},{7,1},{-15,12},{-17,9},{19,-9},{1,0},{9,-10},{6,20},{-12,-4},{-16,-17},{14,3},{0,-1},{-18,9},{-15,15},{-3,-15},{-5,20},{15,-14},{9,-17},{10,-14},{-7,-11},{14,9},{1,-1},{15,12},{-5,-1},{-17,-5},{15,-2},{-12,11},{19,-18},{8,7},{-5,-3},{-17,-1},{-18,13},{15,-3},{4,18},{-14,-15},{15,8},{-18,-12},{-15,19},{-9,16},{-9,14},{-12,-14},{-2,-20},{-3,-13},{10,-7},{-2,-10},{9,10},{-1,7},{-17,-6},{-15,20},{5,-17},{6,-6},{-11,-8}};
        int result = maxPoints.maxPoints(points);
        System.out.println(result);
    }
}
