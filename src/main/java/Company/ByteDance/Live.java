package Company.ByteDance;

import java.util.Scanner;

/**
 * Created by rui on 2018/8/12.
 */
public class Live {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int live[][] = new int[n][2];
        int value[][] = new int[n][2];
        int maxCount[] = new int[n];
        int count=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<2;j++){
                live[i][j] = scanner.nextInt();
            }
        }
        value[0][0] = live[0][0];
        value[0][1] = live[0][1];
        maxCount[0]=1;
    }
}
