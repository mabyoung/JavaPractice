package SwordOffer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class InversePairs {
    public static long count;

    public static void sort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(array, left, mid);
            sort(array, mid + 1, right);
            merge(array, left, right);
        }
    }

    public static void merge(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, tmpIndex = 0;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                tmp[tmpIndex++] = array[i++];
            } else {
                tmp[tmpIndex++] = array[j++];
                count += mid - i + 1;
            }
        }
        while (i <= mid) {
            tmp[tmpIndex++] = array[i++];
        }
        while (j <= right) {
            tmp[tmpIndex++] = array[j++];
        }
        for (i = 0; i < tmp.length; i++) {
            array[left + i] = tmp[i];
        }
    }

    public static int inversePairs(int[] array) {
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array
        ));
        return (int)(count % 1000000007);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().trim().split(",");
        int input[] = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            input[i] = Integer.parseInt(split[i]);
        }
        int i = inversePairs(input);
        System.out.println(i);
    }
}
