package Company.Paradigm4;

import java.util.Scanner;

/**
 * Created by rui on 2018/9/9.
 */
public class LongestSymmetryString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] a = scanner.nextLine().trim().toCharArray();
        char[] b = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[a.length - i - 1];
        }
        int LCS[][];
        int maxLength = 0, maxi = 0;
        LCS = new int[a.length + 1][b.length + 1];
        for (int index = 0; index <= a.length; index++) {
            LCS[index][0] = 0;
        }
        for (int index = 0; index <= b.length; index++) {
            LCS[0][index] = 0;
        }
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                    if (LCS[i][j] > maxLength) {
                        maxLength = LCS[i][j];
                        maxi = i - 1;
                    }
                } else {
                    LCS[i][j] = 0;
                }
            }
        }
        if (maxLength > 0) {
            for (int index = maxi - maxLength + 1; index <= maxi; index++) {
                System.out.print(a[index]);
            }
        }
    }
}
