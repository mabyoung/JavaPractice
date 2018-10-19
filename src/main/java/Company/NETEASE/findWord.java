package Company.NETEASE;

import java.util.Scanner;

/**
 * Created by rui on 2018/8/11.
 */
public class findWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int totalNum = ((n*m)*(n*m-1)/2);
        if (k>totalNum){
            System.out.println("-1");
            return;
        }
        if (n==0){
            for (int i=0;i<k;i++){
                System.out.println("z");
            }
        }
        if (m==0){
            for (int i=0;i<k;i++){
                System.out.println("a");
            }
        }
    }
}
