package DataStructure.sort;

import java.util.Scanner;

/**
 * Created by rui on 2018/8/31.
 */
public class HeapSort {
    public static void shif(int[] array, int low, int high) {
        int i = low;
        int j = 2 * (i + 1) - 1;
        int guest = array[i];
        while (j <= high) {
            if (j < high && array[j] < array[j + 1]) {
                j++;
            }
            if (guest < array[j]) {
                array[i] = array[j];
                i = j;
                j = 2 * (i + 1) - 1;
            } else {
                break;
            }
        }
        array[i] = guest;
    }

    public static void heapSort(int[] array) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            shif(array, i, n - 1);
        }
        for (int i = n - 1; i >= 1; i--) {
            int tmp = array[i];
            array[i] = array[0];
            array[0] = tmp;
            shif(array, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        heapSort(array);
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
