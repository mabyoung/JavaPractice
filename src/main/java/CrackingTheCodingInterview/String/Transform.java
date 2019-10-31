package CrackingTheCodingInterview.String;

public class Transform {
    public int[][] transformImage(int[][] mat, int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                int tmp = mat[i][j];
                mat[i][j] = mat[n-1-j][n-1-i];
                mat[n-1-j][n-1-i] = tmp;
            }
        }
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = mat[i][j];
                mat[i][j] = mat[n-1-i][j];
                mat[n-1-i][j] = tmp;
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        Transform transform = new Transform();
        int[][] result = transform.transformImage(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 3);
        System.out.println(result);
    }
}
