package tiba;

import java.util.*;

/**
 * 题意
 * 牛牛在一个迷宫中，迷宫有 nn 个格子，有 mm 条通道，每条通道连接两个格子 uu, vv，编号为 uu 的格子与编号为 vv 的格子可互相到达，每人每条通道只能走一次。
 * 牛牛想知道，他是否能从 11 号格子出发回到 11 号格子。
 * 输入
 * 第一行给定两个整数 nn , mm 。
 * 接下来 mm 行，每行有两个整数 uu，vv 。
 * 1 \leq n \leq 100,000 \quad 0 \leq m \leq 100,000\quad 0 \leq L \leq m1≤n≤100,0000≤m≤100,0000≤L≤m
 * m对 u, v 互不相同
 * 输出
 * 若能回到 11 号格子则返回Yes，否则返回No
 */
public class Maze {
    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class PointWithLocation {
        Point point;
        int location;

        public PointWithLocation(Point point, int location) {
            this.point = point;
            this.location = location;
        }
    }

    /**
     * 能回到1号点返回 Yes，否则返回 No
     *
     * @param param int整型一维数组 param[0] 为 n，param[1] 为 m
     * @param edge  Point类一维数组 Point.x , Point.y 分别为一条边的两个点
     * @return string字符串
     */
    public String solve(int[] param, Point[] edge) {
        Set<Point> visited = new HashSet<>();
        Map<Integer, List<Point>> locationMap = new HashMap<>();
        for (Point point : edge) {
            if (!locationMap.containsKey(point.x)) {
                locationMap.put(point.x, new ArrayList<>());
            }
            locationMap.get(point.x).add(point);
            if (!locationMap.containsKey(point.y)) {
                locationMap.put(point.y, new ArrayList<>());
            }
            locationMap.get(point.y).add(point);
        }
        for (Point point : locationMap.get(1)) {
            int location = point.x == 1 ? point.y : point.x;
            visited.add(point);
            if (dfs(locationMap, location, visited, edge.length)) {
                return "Yes";
            }
        }
        return "No";
    }

    private boolean bfs(Point[] edge, boolean[] visited, Set<Integer> arriveSet, LinkedList<Point> queue) {
        while (!queue.isEmpty()) {
            Point first = queue.getFirst();
            if (first.x != first.y && arriveSet.contains(first.x) && arriveSet.contains(first.y)) {
                return true;
            }
            arriveSet.add(first.x);
            arriveSet.add(first.y);
            queue.removeFirst();
            for (int i = 0; i < edge.length; i++) {
                if (visited[i]) {
                    continue;
                }
                if (edge[i].x == first.x || edge[i].x == first.y || edge[i].y == first.x || edge[i].y == first.y) {
                    queue.add(edge[i]);
                    visited[i] = true;
                }
            }
        }
        return false;
    }

    private boolean dfs(Map<Integer, List<Point>> locationMap, int location, Set<Point> visited, int maxPointNum) {
        if (visited.size() >= maxPointNum) {
            return false;
        }
        for (Point point : locationMap.get(location)) {
            if (visited.contains(point)) {
                continue;
            }
            int nextMove = point.x == location ? point.y : point.x;
            if (nextMove == 1) {
                return true;
            }
            visited.add(point);
            if (dfs(locationMap, nextMove, visited, maxPointNum)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Maze maze = new Maze();
        Point point1 = new Point(1, 3);
        Point point2 = new Point(1, 4);
        Point point3 = new Point(2, 3);
        Point point4 = new Point(2, 4);
        String result = maze.solve(new int[]{4, 4}, new Point[]{point2, point1, point3, point4});
        System.out.println(result);
    }
}
