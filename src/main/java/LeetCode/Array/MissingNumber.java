package LeetCode.Array;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        boolean[] array = new boolean[n + 1];
        for (int num : nums) {
            array[num] = true;
        }
        for (int i = 0; i < array.length; i++) {
            if (!array[i]) {
                return i;
            }
        }
        return -1;
    }
}
