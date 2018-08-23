package DataStructure.sort;

public class QuickSort {
    void sort(int array[], int low, int high) {
        if (low < high) {
            int i = low, j = high, pivot = array[i];
            while (i < j) {
                while (i < j && array[j] >= pivot) {
                    j--;
                }
                if (i == j) {
                    break;
                } else {
                    array[i++] = array[j];
                }
                while (i < j && array[i] <= pivot) {
                    i++;
                }
                if (i == j) {
                    break;
                } else {
                    array[j--] = array[i];
                }
            }
            array[i] = pivot;
            sort(array, low, i - 1);
            sort(array, i + 1, high);
        }
    }

    public static void main(String[] args) {
        int array[] = {2, 3, 5, 1, 3, 4, 5, 8, 3, 5, 2};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array, 0, array.length - 1);
        for (int item : array) {
            System.out.print(item + " ");
        }
    }
}
