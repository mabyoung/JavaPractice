package SwordOffer;

import java.util.Scanner;

public class ReOrderArray {
    public static void reOrderArray(int[] array) {
        int[] tmp = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                tmp[index++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                tmp[index++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        reOrderArray(array);
        for (int item : array) {
            System.out.print(item+" ");
        }
    }
}
