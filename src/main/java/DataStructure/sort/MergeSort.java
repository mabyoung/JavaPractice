package DataStructure.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(array, 0, mid);
            sort(array, mid + 1, right);
            merge(array, left, right, mid);
        }
    }

    public static void merge(int[] array, int left, int right, int mid) {
        int i = left, j = mid + 1;
        int tmp[] = new int[right - left + 1];
        int tmpIndex = 0;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                tmp[tmpIndex++] = array[i];
                i++;
            } else {
                tmp[tmpIndex++] = array[j];
                j++;
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
}

