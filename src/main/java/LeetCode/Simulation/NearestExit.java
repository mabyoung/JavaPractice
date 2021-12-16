package LeetCode.Simulation;

import java.util.LinkedList;

public class NearestExit {
    class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int step = 0;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        LinkedList<Position> queue = new LinkedList<>();
        queue.addLast(new Position(entrance[0], entrance[1]));
        visited[entrance[0]][entrance[1]] = true;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            step++;
            for (int i = 0; i < queueSize; i++) {
                Position now = queue.pollFirst();
                if (isOk(maze, now.x + 1, now.y) && !visited[now.x + 1][now.y]) {
                    if (isExit(maze, now.x + 1, now.y)) {
                        return step;
                    }
                    queue.addLast(new Position(now.x + 1, now.y));
                    visited[now.x + 1][now.y] = true;
                }
                if (isOk(maze, now.x - 1, now.y) && !visited[now.x - 1][now.y]) {
                    if (isExit(maze, now.x - 1, now.y)) {
                        return step;
                    }
                    queue.addLast(new Position(now.x - 1, now.y));
                    visited[now.x - 1][now.y] = true;
                }
                if (isOk(maze, now.x, now.y + 1) && !visited[now.x][now.y + 1]) {
                    if (isExit(maze, now.x, now.y + 1)) {
                        return step;
                    }
                    queue.addLast(new Position(now.x, now.y + 1));
                    visited[now.x][now.y + 1] = true;
                }
                if (isOk(maze, now.x, now.y - 1) && !visited[now.x][now.y - 1]) {
                    if (isExit(maze, now.x, now.y - 1)) {
                        return step;
                    }
                    queue.addLast(new Position(now.x, now.y - 1));
                    visited[now.x][now.y - 1] = true;
                }
            }

        }
        return -1;
    }

    public boolean isExit(char[][] maze, int x, int y) {
        int m = maze.length;
        int n = maze[0].length;
        return x == 0 || x == m - 1 || y == 0 || y == n - 1;
    }

    public boolean isOk(char[][] maze, int x, int y) {
        int m = maze.length;
        int n = maze[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        return maze[x][y] == '.';
    }

    public static void main(String[] args) {
        NearestExit nearestExit = new NearestExit();
        int result = nearestExit.nearestExit(new char[][]{{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}}, new int[]{1, 2});
        System.out.println(result);
    }
}
