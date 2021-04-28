package CrackingTheCodingInterview.Basis;

/**
 * 约瑟夫问题是一个非常著名的趣题，即由n个人坐成一圈，按顺时针由1开始给他们编号。然后由第一个人开始报数，数到m的人出局。现在需要求的是最后一个出局的人的编号。
 * 给定两个int n和m，代表游戏的人数。请返回最后一个出局的人的编号。保证n和m小于等于1000。
 */
public class Joseph {
    public int getResult(int n, int m) {
        boolean[] circle = new boolean[n];
        int outNum = 0;
        int cursor = 0;
        int count = 1;
        while (outNum < n) {
            if (cursor == n) {
                cursor = 0;
            }
            if (!circle[cursor]) {
                if (count == m) {
                    circle[cursor] = true;
                    outNum++;
                    count = 1;
                } else {
                    count++;
                }
            }
            cursor++;
        }
        return cursor;
    }

    public static void main(String[] args) {
        Joseph joseph = new Joseph();
        System.out.println(joseph.getResult(3, 3));
    }
}
