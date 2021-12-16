package LeetCode.Array;

public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        Integer lastItem = null;
        int continueCount = 0;
        int maxContinueCount = 0;
        for (int num : nums) {
            if (lastItem == null) {
                continueCount = 1;
            } else if (num > lastItem) {
                continueCount++;
            } else {
                continueCount = 1;
            }
            maxContinueCount = Math.max(maxContinueCount, continueCount);
            lastItem = num;
        }
        return maxContinueCount;
    }
}
