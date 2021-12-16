package LeetCode.Array;

public class NumberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int[] gap = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            gap[i] = nums[i + 1] - nums[i];
        }
        int result = 0;
        int left = 0;
        int right = 0;
        while (right < gap.length) {
            if (gap[right] == gap[left]) {
                right++;
            } else {
                if (right - left >= 2) {
                    result += (right - left) * (right - left - 1) / 2;
                }
                left = right;
            }
        }
        if (right - left >= 2) {
            result += (right - left) * (right - left - 1) / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfArithmeticSlices numberOfArithmeticSlices = new NumberOfArithmeticSlices();
        System.out.println(numberOfArithmeticSlices.numberOfArithmeticSlices(new int[]{1,2,3,4,5,5,5,5,6,7}));
    }
}
