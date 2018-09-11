package Company.Renren;

import java.util.Scanner;

public class Main {
    public static void shift(int[] array, int low, int high) {
        int i = low;
        int j = (i + 1) * 2 - 1;
        int tmp = array[i];
        while (j < high) {
            if (array[j] < array[j + 1]) {
                j++;
            }
            if (array[j] > tmp) {
                array[i] = array[j];
                i = j;
                j = (i + 1) * 2 - 1;
            }else{
                break;
            }
        }
        array[i] = tmp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        for (int i =n/2-1;i>=0;i--){
            shift(input, i, n-1);
        }
        for (int i = n-1;i>=n-k+1;i--){
            int tmp = input[i];
            input[i] = input[0];
            input[0] =tmp;
            shift(input, 0, i);
        }
        System.out.println(input[0]);
    }
}
