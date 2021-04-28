package CrackingTheCodingInterview.Recursive;

/**
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
 * 给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
 * <p>
 * <p>
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。注意这次的网格中有些障碍点是不能走的。
 * 给定一个int[][] map(C++ 中为vector >),表示网格图，若map[i][j]为1则说明该点不是障碍点，否则则为障碍。另外给定int x,int y，表示网格的大小。请返回机器人从(0,0)走到(x - 1,y - 1)的走法数，为了防止溢出，请将结果Mod 1000000007。保证x和y均小于等于50
 */
public class Robot {
    public int countWays(int x, int y) {
        int[][] board = new int[x][y];
        for (int i = x - 1; i >= 0; i--) {
            for (int j = y - 1; j >= 0; j--) {
                if (i == x - 1 || j == y - 1) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = board[i + 1][j] + board[i][j + 1];
                }
            }
        }
        return board[0][0];
    }

    public int countWays(int[][] map, int x, int y) {
        int m = map.length;
        int n = map[0].length;
        int[][] board = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (map[i][j] != 1) {
                    board[i][j] = 0;
                } else if (i == m - 1 && j == n - 1) {
                    board[i][j] = 1;
                } else if (i == m - 1) {
                    board[i][j] = board[i][j + 1];
                } else if (j == n - 1) {
                    board[i][j] = board[i + 1][j];
                } else {
                    board[i][j] = (board[i + 1][j] + board[i][j + 1]) % 1000000007;
                }
            }
        }
        return board[0][0];
    }

    public static void main(String[] args) {
        Robot robot = new Robot();
        int result = robot.countWays(2, 2);
        System.out.println(result);
    }
}
