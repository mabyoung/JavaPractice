package OldExams2016.Dynamic;

public class Visit {
    public int countPath(int[][] map, int n, int m) {
        int pointAx = -1;
        int pointAy = -1;
        int pointBx = -1;
        int pointBy = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 || map[i][j] == 2) {
                    if (pointAx == -1) {
                        pointAx = i;
                        pointAy = j;
                    } else {
                        pointBx = i;
                        pointBy = j;
                    }
                }
            }
        }
        if (pointAy < pointBy) {
            return fromLeftUpToRightDown(map, pointAx, pointAy, pointBx, pointBy);
        } else {
            return fromRightUpToLeftDown(map, pointAx, pointAy, pointBx, pointBy);
        }
    }

    private int fromLeftUpToRightDown(int[][] map, int pointAx, int pointAy, int pointBx, int pointBy) {
        int[][] board = new int[map.length][map[0].length];
        for (int i = pointAx; i <= pointBx; i++) {
            if (map[i][pointAy] == -1) {
                break;
            } else {
                board[i][pointAy] = 1;
            }
        }
        for (int j = pointAy; j <= pointBy; j++) {
            if (map[pointAx][j] == -1) {
                break;
            } else {
                board[pointAx][j] = 1;
            }
        }
        for (int i = pointAx + 1; i <= pointBx; i++) {
            for (int j = pointAy + 1; j <= pointBy; j++) {
                if (map[i][j] != -1) {
                    board[i][j] = board[i - 1][j] + board[i][j - 1];
                }
            }
        }
        return board[pointBx][pointBy];
    }

    private int fromRightUpToLeftDown(int[][] map, int pointAx, int pointAy, int pointBx, int pointBy) {
        int[][] board = new int[map.length][map[0].length];
        for (int i = pointAx; i <= pointBx; i++) {
            if (map[i][pointAy] == -1) {
                break;
            } else {
                board[i][pointAy] = 1;
            }
        }
        for (int j = pointAy; j >= pointBy; j--) {
            if (map[pointAx][j] == -1) {
                break;
            } else {
                board[pointAx][j] = 1;
            }
        }
        for (int i = pointAx + 1; i <= pointBx; i++) {
            for (int j = pointAy - 1; j >= pointBy; j--) {
                if (map[i][j] != -1) {
                    board[i][j] = board[i - 1][j] + board[i][j + 1];
                }
            }
        }
        return board[pointBx][pointBy];
    }

    public static void main(String[] args) {
        Visit visit = new Visit();
        int result = visit.countPath(new int[][]{{0,0,0,0,0}, {0,0,0,0,0},{0,0,0,1,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,2}}, 7, 5);
        System.out.println(result);
    }
}
