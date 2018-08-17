package Company.ByteDance;

import java.util.Scanner;

/**
 * Created by rui on 2018/8/12.
 */
public class MaxAndMin {
    private static int[]arrayA;
    private static int[]arrayB;
    private static int[]maxA;
    private static int[]minB;
    private static int n;
    private static int count=0;
    private static void maxAndMin(){
        for (int i=0;i<n;i++){
            for (int j=i;j>=0;j--){
                if (j==i){
                    maxA[j]=arrayA[j];
                    minB[j]=arrayB[j];
                    if (maxA[j]<minB[j]){
                        count++;
                    } else {
                        break;
                    }
                }else {
                    if (arrayA[j]>maxA[i]){
                        maxA[i]=arrayA[j];
                    }
                    if (arrayB[j]<minB[i]){
                        minB[i]=arrayB[j];
                    }
                    if (maxA[i]<minB[i]){
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        arrayA = new int[n];
        arrayB = new int[n];
        maxA = new int[n];
        minB = new int[n];
        for (int i=0;i<n;i++){
            arrayA[i]=scanner.nextInt();
        }
        for (int i=0;i<n;i++){
            arrayB[i]=scanner.nextInt();
        }
        maxAndMin();
        System.out.println(count);
    }
}
