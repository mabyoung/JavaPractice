package LeetCode.Array;

public class FindErrorNums {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[nums[i] - 1]++;
        }
        int[] result = new int[2];
        for (int i = 0; i < n; i++) {
            if (array[i] == 0) {
                result[1] = i + 1;
            } else if (array[i] > 1) {
                result[0] = i + 1;
            }
        }
        return result;
    }
}
