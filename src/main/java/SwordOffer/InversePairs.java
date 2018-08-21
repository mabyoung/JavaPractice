package SwordOffer;

import java.util.Scanner;

public class InversePairs {
    public static int inversePairs(int[] array){
        int count = 0;
        for (int i=array.length-1;i>=0;i--){
            for (int j=i-1;j>=0;j--){
                if (array[i]<array[j]){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().trim().split(",");
        int input[] = new int[split.length];
        for (int i = 0;i<split.length;i++){
            input[i] = Integer.parseInt(split[i]);
        }
        int i = inversePairs(input);
        System.out.println(i);
    }
}
