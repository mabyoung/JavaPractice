package LeetCode.Graph;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor){
            paint(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }

    public void paint(int[][] image, int x, int y, int oldColor, int newColor) {
        int m = image.length;
        int n = image[0].length;
        if (x >= 0 && x < m && y >= 0 && y < n && image[x][y] == oldColor) {
            image[x][y] = newColor;
            paint(image, x + 1, y, oldColor, newColor);
            paint(image, x - 1, y, oldColor, newColor);
            paint(image, x, y + 1, oldColor, newColor);
            paint(image, x, y - 1, oldColor, newColor);
        }
    }
}
