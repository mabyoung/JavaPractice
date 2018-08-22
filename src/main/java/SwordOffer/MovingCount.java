package SwordOffer;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MovingCount {
    public static int movingCount(int threshold, int rows, int cols) {
        int[][] visit = new int[rows][cols];
        int count = dfs(threshold, rows, cols, 0, 0, visit);
        return count;
    }

    public static int dfs(int threshold, int rows, int cols, int i, int j, int[][] visit) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || getDigitSum(i, j) > threshold || visit[i][j] == 1) {
            return 0;
        }
        visit[i][j] = 1;
        return dfs(threshold, rows, cols, i - 1, j, visit)+
        dfs(threshold, rows, cols, i, j + 1, visit)+
        dfs(threshold, rows, cols, i + 1, j, visit)+
        dfs(threshold, rows, cols, i, j - 1, visit)+1;
    }

    public static int getDigitSum(int i, int j) {
        String str = "" + i + j;
        char[] chars = str.toCharArray();
        int sum = 0;
        for (char c : chars) {
            sum += c - '0';
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(15, 20, 20));
    }
}
