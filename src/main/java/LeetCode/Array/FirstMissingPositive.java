package LeetCode.Array;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * <p>
 * For example,
 * Given[1,2,0]return3,
 * and[3,4,-1,1]return2.
 * <p>
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0 && A[i] <= A.length && A[i] != A[A[i] - 1]) {
                int tmp = A[i];
                A[i--] = A[tmp - 1];
                A[tmp - 1] = tmp;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }

    //使用了O(n)的空间
    public int firstMissingPositive1(int[] A) {
        int[] num = new int[A.length];
        for (int item : A) {
            if (item > 0 && item <= A.length) {
                num[item - 1] = 1;
            }
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i] == 0) {
                return i + 1;
            }
        }
        return num.length + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{2,2,2}));
    }
}
