package LeetCode.Array;

/**
 * 继续思考题目"Remove Duplicates":
 * 如果数组中元素最多允许重复两次呢？
 * 例如：
 * 给出有序数组 A =[1,1,1,2,2,3],
 * 你给出的函数应该返回length =5,  A 变为[1,1,2,2,3].
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] A) {
        if (A.length <= 2) {
            return A.length;
        }
        int index = 2;
        for (int i = 2; i < A.length; i++) {
            if (A[i] != A[index - 2]) {
                A[index++] = A[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArrayII = new RemoveDuplicatesFromSortedArrayII();
        int[] A = new int[]{1, 1, 1, 2, 2, 2, 2, 3};
        int result = removeDuplicatesFromSortedArrayII.removeDuplicates(A);
        for (int i = 0; i < result; i++) {
            System.out.println(A[i]);
        }
    }
}
