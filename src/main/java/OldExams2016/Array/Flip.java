package OldExams2016.Array;

/**
 * 在4x4的棋盘上摆满了黑白棋子，黑白两色的位置和数目随机其中左上角坐标为(1,1),右下角坐标为(4,4),现在依次有一些翻转操作，
 * 要对一些给定支点坐标为中心的上下左右四个棋子的颜色进行翻转，请计算出翻转后的棋盘颜色。
 * 给定两个数组A和f,分别为初始棋盘和翻转位置。其中翻转位置共有3个。请返回翻转后的棋盘。
 */
public class Flip {
    public int[][] flipChess(int[][] A, int[][] f) {
        for (int[] ints : f) {
            flip(A, ints[0]-2, ints[1]-1);
            flip(A, ints[0]-1, ints[1]);
            flip(A, ints[0]-1, ints[1]-2);
            flip(A, ints[0], ints[1]-1);
        }
        return A;
    }

    private void flip(int[][] A, int i, int j) {
        if (i >= 0 && j >= 0 && i < A.length && j < A.length) {
            A[i][j] = 1 - A[i][j];
        }
    }

    public static void main(String[] args) {
        Flip flip = new Flip();
        int[][] result = flip.flipChess(new int[][]{{0, 1, 0, 0}, {1, 0, 1, 0}, {1, 1, 0, 0}, {1, 0, 0, 1}}, new int[][]{{2, 3}, {4, 2}, {2, 3}});
        System.out.println(result);
    }
}
