package byteDance;

import java.util.Arrays;
import java.util.Scanner;

public class ExamQuestion {
    public static int sum = 0;
    public static void analysi(int[] input, int n){
        Arrays.sort(input);
        int count = 0;
        for (int i = 0; i < n; i++){
             count++;
            if (i == n-1){
                sum += 3 - count;
                count = 0;
                return;
            }
            if (count == 3){
                count = 0;
                continue;
            }
            if (input[i+1] - input[i] > 10){
                sum += 3 - count;
                count = 0;
                continue;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        String origin = scanner.nextLine().trim();
        String[] split = origin.split(" ");
        int[] input = new int[n];
        for (int i = 0; i < n; i++){
            input[i] = Integer.parseInt(split[i]);
        }
        analysi(input, n);
        System.out.println(sum);
    }
}
