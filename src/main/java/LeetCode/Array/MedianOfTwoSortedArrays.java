package LeetCode.Array;

/**
 * 有两个大小分别为m和n的有序数组A和B。请找出这两个数组的中位数。你需要给出时间复杂度在O(log (m+n))以内的算法。
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int totalLength = A.length + B.length;
        if (totalLength % 2 == 1) {
            return findKth(A, 0, B, 0, totalLength / 2 + 1);
        } else {
            return (findKth(A, 0, B, 0, totalLength / 2) + findKth(A, 0, B, 0, totalLength / 2 + 1)) / 2.0;
        }
    }

    private double findKth(int[] A, int i, int[] B, int j, int k) {
        if (A.length - i > B.length - j) {
            return findKth(B, j, A, i, k);
        }
        if (i >= A.length) {
            return B[j + k - 1];
        }
        if (k == 1) {
            return Math.min(A[i], B[j]);
        }
        int pa = Math.min(k / 2, A.length - i);
        int pb = k - pa;
        if (A[i + pa - 1] == B[j + pb - 1]) {
            return A[i + pa - 1];
        } else if (A[i + pa - 1] < B[j + pb - 1]) {
            return findKth(A, i + pa, B, j, k - pa);
        } else {
            return findKth(A, i, B, j + pb, k - pb);
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        double median = medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1}, new int[]{2, 3, 4, 5, 6});
        System.out.println(median);
    }
}
