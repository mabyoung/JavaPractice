package LeetCode.Array;

public class IsMonotonic {
    public boolean isMonotonic(int[] nums) {
        return isOkA(nums)||isOkB(nums);
    }

    public boolean isOkA(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > nums[i]){
                return false;
            }
        }
        return true;
    }

    public boolean isOkB(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] < nums[i]){
                return false;
            }
        }
        return true;
    }
}
