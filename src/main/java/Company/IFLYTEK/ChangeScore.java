package Company.IFLYTEK;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rui on 2018/9/7.
 */
public class ChangeScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i=0;i<T;i++){
            int n = scanner.nextInt();
            int X = scanner.nextInt();
            int[] score = new int[n];
            int sum = 0;
            for (int j=0;j<n;j++){
                score[j] = scanner.nextInt();
                sum += score[j];
            }
            if (sum>=n*X){
                System.out.println(0);
                continue;
            }
            Arrays.sort(score);
            int index = 0;
            while (100-score[index]+sum < n*X){
                sum +=100-score[index];
                index++;
            }
            System.out.println(index+1);
        }
    }
}
