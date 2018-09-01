package Company.pdd;

import java.util.Scanner;

/**
 * Created by rui on 2018/8/30.
 */
public class qipan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().trim().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        char[][] key = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] chars = scanner.nextLine().trim().toCharArray();
            System.arraycopy(chars, 0, key[i], 0, m);
        }
        for (int j = 0; j < m; j++) {
            int x = -1;
            int y = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (key[i][j] == '.') {
                    continue;
                }
                if (key[i][j] == 'o' && x == -1) {
                    key[i][j] = '.';
                } else if (key[i][j] == 'o' && x != -1) {
                    key[i][j] = '.';
                    if (y == -1) {
                        key[x - 1][j] = 'o';
                        y = x - 1;
                    } else {
                        key[y - 1][j] = 'o';
                        y = y - 1;
                    }
                } else if (key[i][j] == 'x') {
                    x = i;
                    y = -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(key[i][j]);
            }
            System.out.println();
        }
    }
}
