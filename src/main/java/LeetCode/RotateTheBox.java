package LeetCode;

public class RotateTheBox {
    public char[][] rotateTheBox(char[][] box) {
        for (int i = 0; i < box.length; i++) {
            for (int j = box[i].length - 1; j >= 0; j--) {
                moveRock(box, i, j);
            }
        }
        return rotate(box);
    }

    private void moveRock(char[][] box, int i, int j) {
        if (box[i][j] == '.' || box[i][j] == '*') {
            return;
        }
        box[i][j] = '.';
        for (int index = j + 1; index <= box[0].length; index++) {
            if (index == box[0].length || box[i][index] == '#' || box[i][index] == '*') {
                box[i][index - 1] = '#';
                return;
            }
        }
    }

    private char[][] rotate(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] result = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][m - i - 1] = box[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RotateTheBox rotateTheBox = new RotateTheBox();
        char[][] box = new char[][]{{'#', '#', '*', '.', '*', '.'}, {'#', '#', '#', '*', '.', '.'}, {'#', '#', '#', '.', '#', '.'}};
        char[][] result = rotateTheBox.rotateTheBox(box);
        for (char[] chars : result) {
            System.out.println(chars);
        }
    }
}
