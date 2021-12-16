package LeetCode.Simulation;

public class FlipAndInvertImage {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] ints : image) {
            reverse(ints);
        }
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                image[i][j] = 1 - image[i][j];
            }
        }
        return image;
    }

    private void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int tmp = array[left];
            array[left++] = array[right];
            array[right--] = tmp;
        }
    }
}
