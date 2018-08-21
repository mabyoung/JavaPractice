package SwordOffer;

public class GetNumberOfK {
    public static int binarySearch(int[] array, int k) {
        int low = 0, high = array.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] == k) {
                return mid;
            } else if (array[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int getNumberOfK(int[] array, int k) {
        int index = binarySearch(array, k);
        if (index == -1) {
            return 0;
        }
        int count = 1;
        int i = index + 1;
        while (i < array.length && array[i++] == k) {
            count++;
        }
        i = index - 1;
        while (i >= 0 && array[i--] == k) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 4, 4, 4, 5};
        int numberOfK = getNumberOfK(array, 1);
        System.out.println(numberOfK);
    }
}
