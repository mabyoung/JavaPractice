package LeetCode.Complexity;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {
    public int singleNumber(int[] A){
        int result = 0;
        for (int item : A) {
            result ^= item;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1,1};
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(A));
    }
}
