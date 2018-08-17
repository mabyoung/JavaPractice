package Company.ByteDance;

import java.util.Scanner;

/**
 * Created by rui on 2018/8/12.
 */
public class UserLike {
    private static int[] likes;
    private static int n;
    private static void userLike(int left, int right, int key){
        int count = 0 ;
        for (int i = left-1;i<right;i++){
            if(likes[i] == key){
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        likes = new int[n];
        for (int i = 0 ;i < n;i++){
            likes[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        int[][] input = new int[q][3];
        for (int i = 0;i<q;i++){
            input[i][0] = scanner.nextInt();
            input[i][1] = scanner.nextInt();
            input[i][2] = scanner.nextInt();
        }
        for (int i = 0;i<q;i++){
            userLike(input[i][0],input[i][1],input[i][2]);
        }
    }
}
