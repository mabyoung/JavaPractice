package Company.Qihoo360;

import java.util.Scanner;

/**
 * Created by rui on 2018/8/27.
 */
public class Array {
    public static int[] arrayA;
    public static int[] arrayB;
    public static int n;
    private static int[][] LCS;
    static int maxLength = 0,maxi,maxj;


    public static int solve() {
        for (int i = 0; i < n / 2; i++) {
            int tmp = arrayB[i];
            arrayB[i] = arrayB[n - 1 - i];
            arrayB[n - 1 - i] = tmp;
        }
        return getLCSLength(arrayA,arrayB);
    }

    static int getLCSLength(int [] a, int [] b){
        int aLength = a.length;
        int bLength = b.length;
        LCS = new int[aLength+1][bLength+1];
        for (int index = 0; index <= a.length; index++){
            LCS[index][0] = 0;
        }
        for (int index = 0; index <= b.length; index++){
            LCS[0][index] = 0;
        }
        for (int i = 1; i <= a.length; i++){
            for (int j = 1; j <= b.length; j++){
                if (a[i-1] == b[j-1]){
                    LCS[i][j] =  LCS[i-1][j-1] + 1;
                    if (LCS[i][j] > maxLength){
                        maxLength = LCS[i][j];
                        maxi = i-1;
                        maxj = j-1;
                    }
                } else {
                    LCS[i][j] = 0;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        arrayA = new int[n];
        arrayB = new int[n];
        for (int i = 0; i < n; i++) {
            arrayA[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arrayB[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }
}
