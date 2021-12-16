package LeetCode.Array;

public class ImageSmoother {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = getAverage(img, i, j);
            }
        }
        return result;
    }

    public int getAverage(int[][] img, int x, int y) {
        int m = img.length;
        int n = img[0].length;
        int sum = 0;
        int count = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < m && j >= 0 && j < n) {
                    sum += img[i][j];
                    count++;
                }
            }
        }
        return sum / count;
    }

    public static void main(String[] args) {
        ImageSmoother imageSmoother = new ImageSmoother();
        int[][] result = imageSmoother.imageSmoother(new int[][]{{1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}});
        System.out.println(result);
    }
}