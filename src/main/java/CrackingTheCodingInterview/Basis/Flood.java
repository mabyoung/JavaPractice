package CrackingTheCodingInterview.Basis;

import java.util.LinkedList;

/**
 * 在一个nxm矩阵形状的城市里爆发了洪水，洪水从(0,0)的格子流到这个城市，在这个矩阵中有的格子有一些建筑，洪水只能在没有建筑的格子流动。
 * 请返回洪水流到(n - 1,m - 1)的最早时间(洪水只能从一个格子流到其相邻的格子且洪水单位时间能从一个格子流到相邻格子)。
 * 给定一个矩阵map表示城市，其中map[i][j]表示坐标为(i,j)的格子，值为1代表该格子有建筑，0代表没有建筑。
 * 同时给定矩阵的大小n和m(n和m均小于等于100)，请返回流到(n - 1,m - 1)的最早时间。保证洪水一定能流到终点。
 */
public class Flood {
    public class PositionWithStep {
        int x;
        int y;
        int step;

        PositionWithStep(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    public int floodFill(int[][] map, int n, int m) {
        LinkedList<PositionWithStep> queue = new LinkedList<>();
        queue.addLast(new PositionWithStep(0, 0, 0));
        int[][] visit = new int[n][m];
        while (!queue.isEmpty()) {
            PositionWithStep positionWithStep = queue.getFirst();
            queue.removeFirst();
            if (positionWithStep.x == n - 1 && positionWithStep.y == m - 1) {
                return positionWithStep.step;
            }
            if (isValid(map, positionWithStep.x - 1, positionWithStep.y) && visit[positionWithStep.x - 1][positionWithStep.y] == 0) {
                queue.add(new PositionWithStep(positionWithStep.x - 1, positionWithStep.y, positionWithStep.step + 1));
                visit[positionWithStep.x - 1][positionWithStep.y] = 1;
            }
            if (isValid(map, positionWithStep.x + 1, positionWithStep.y) && visit[positionWithStep.x + 1][positionWithStep.y] == 0) {
                queue.add(new PositionWithStep(positionWithStep.x + 1, positionWithStep.y, positionWithStep.step + 1));
                visit[positionWithStep.x + 1][positionWithStep.y] = 1;
            }
            if (isValid(map, positionWithStep.x, positionWithStep.y - 1) && visit[positionWithStep.x][positionWithStep.y - 1] == 0) {
                queue.add(new PositionWithStep(positionWithStep.x, positionWithStep.y - 1, positionWithStep.step + 1));
                visit[positionWithStep.x][positionWithStep.y - 1] = 1;
            }
            if (isValid(map, positionWithStep.x, positionWithStep.y + 1) && visit[positionWithStep.x][positionWithStep.y + 1] == 0) {
                queue.add(new PositionWithStep(positionWithStep.x, positionWithStep.y + 1, positionWithStep.step + 1));
                visit[positionWithStep.x][positionWithStep.y + 1] = 1;
            }
        }
        return -1;
    }

    private boolean isValid(int[][] map, int x, int y) {
        return (x >= 0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] == 0);
    }
}
