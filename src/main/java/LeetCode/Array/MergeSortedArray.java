package LeetCode.Array;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * <p>
 * Note:
 * You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int i = m, j = n;
        while (i > 0 && j > 0) {
            A[i + j - 1] = A[i - 1] > B[j - 1] ? A[--i] : B[--j];
        }
        while (j > 0) {
            A[j - 1] = B[--j];
        }
    }

    public static void main(String[] args) {
        int A[] = new int[]{1, 3, 5, 1, 1, 1};
        int B[] = new int[]{2, 4, 6};
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(A, 3, B, 3);
        for (int item : A) {
            System.out.println(item);
        }
    }
}
