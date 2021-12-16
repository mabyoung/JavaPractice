package LeetCode;

public class TotalHammingDistance {
    private static final int HIGH_BIT = 32;

    public int totalHammingDistance(int[] nums) {
        int result = 0;
        for (int i = 0; i < HIGH_BIT; i++) {
            int zeroNum = 0;
            for (int num : nums) {
                zeroNum += (num >> i) & 1;
            }
            result += zeroNum * (nums.length - zeroNum);
        }
        return result;
    }
}
