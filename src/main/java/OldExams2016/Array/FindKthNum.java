package OldExams2016.Array;

public class FindKthNum {
    public int findKthNum(int[] arr1, int[] arr2, int kth) {
        int i = 0, j = 0;
        while (true) {
            if (kth == 1) {
                return Math.min(arr1[i], arr2[j]);
            }
            if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
            kth--;
            if (i == arr1.length) {
                return arr2[j + kth - 1];
            } else if (j == arr2.length) {
                return arr1[i + kth - 1];
            }
        }
    }

    public static void main(String[] args) {
        FindKthNum findKthNum = new FindKthNum();
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{3, 4, 5, 6};
        int result = findKthNum.findKthNum(arr1, arr2, 2);
        System.out.println(result);
    }
}
