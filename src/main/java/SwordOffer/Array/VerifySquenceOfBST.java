package SwordOffer.Array;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
    public static boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length==0){
            return false;
        }
        return verifyHelper(sequence, 0, sequence.length - 1);
    }

    public static boolean verifyHelper(int[] sequence, int begin, int end) {
        if (begin >= end) {
            return true;
        }
        int index;
        for (index = 0; index <= end; index++) {
            if (sequence[index] >= sequence[end]) {
                break;
            }
        }
        if (!isAllBigThenKey(sequence, index, end - 1, sequence[end])) {
            return false;
        }
        return verifyHelper(sequence, begin, index - 1) && verifyHelper(sequence, index, end - 1);
    }

    public static boolean isAllBigThenKey(int[] sequence, int begin, int end, int key) {
        for (int i = begin; i <= end; i++) {
            if (sequence[i] < key) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] sequence = {7,4,6,5};
        System.out.println(verifySquenceOfBST(sequence));
    }
}
