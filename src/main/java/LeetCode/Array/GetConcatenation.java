package LeetCode.Array;

public class GetConcatenation {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] result = new int[2 * n];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
            result[i + n] = nums[i];
        }
        return result;
    }
}
