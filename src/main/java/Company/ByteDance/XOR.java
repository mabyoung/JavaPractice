package Company.ByteDance;

import java.util.Scanner;

public class XOR {
    public static int getXORNum(int[] input, int n, int m){
        int sum = 0;
        for (int i = 0; i < n-1; i++){
            for (int j = i+1; j < n; j++){
                if ((input[i]^input[j])>m){
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(6^10);
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().trim().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        split = scanner.nextLine().trim().split(" ");
        int[] input = new int[n];
        for (int i = 0; i < n; i++){
            input[i] = Integer.parseInt(split[i]);
        }
        int result = getXORNum(input, n, m);
        System.out.println(result);
    }
}
