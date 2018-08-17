package Company.Net163;

import java.util.Scanner;

public class kesui {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int input[][] = new int[n][2];
        int value[] = new int[n];
        for (int i = 0 ;i< n;i++){
            input[i][0] = scanner.nextInt();
        }
        for (int i = 0 ;i< n;i++){
            input[i][1] = scanner.nextInt();
        }
        for (int i = 0; i <k;i++){
            if (input[i][1] == 0){
                value[0]+=input[i][0];
            }
        }
        int max = value[0];
        int sum =0;
        if (input[0][1]==1){
            sum = input[0][0];
        }
        for (int i = 1; i <n;i++){
            value[i]=value[i-1];
            if (input[i-1][1] == 0){
                value[i]-=input[i-1][0];
            }
            if (i+k-1<n && input[i+k-1][1] == 0){
                value[i]+=input[i+k-1][0];
            }
            if (input[i][1] == 1){
                sum+=input[i][0];
            }
            if (value[i]>max){
                max=value[i];
            }
        }
        System.out.println(max+sum);
    }
}
