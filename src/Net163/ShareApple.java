package Net163;

import java.util.Scanner;

public class ShareApple {
    private static int shareApple(int[] apples, int n){
        int sum = 0;
        int count = 0;
        for (int i=0;i<n;i++){
            sum+=apples[i];
        }
        if (sum % n != 0){
            return -1;
        }
        int targetNum = sum/n;
        for (int i = 0;i<n;i++){
            int abs = Math.abs(apples[i] - targetNum);
            if (abs % 2 != 0){
                return -1;
            } else {
                count +=abs/2;
            }
        }
        return count/2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        String[] split = scanner.nextLine().trim().split(" ");
        int[] apples = new int[n];
        for (int i = 0;i< n;i++){
            apples[i] = Integer.parseInt(split[i]);
        }
        System.out.println(shareApple(apples, n));
    }
}
