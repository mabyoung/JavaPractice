package LeetCode;

public class FindTargetSumWays {
    int result = 0;

    public int findTargetSumWays(int[] nums, int target) {
        findTargetSumWays(nums, target, 0, 0);
        return result;
    }

    public void findTargetSumWays(int[] nums, int target, int curIndex, int curSum){
        if (curIndex == nums.length){
            if (curSum == target){
                result++;
            }
        }else{
            findTargetSumWays(nums, target, curIndex+1, curSum+nums[curIndex]);
            findTargetSumWays(nums, target, curIndex+1, curSum-nums[curIndex]);
        }
    }

    public static void main(String[] args) {
        FindTargetSumWays findTargetSumWays  =new FindTargetSumWays();
        int result = findTargetSumWays.findTargetSumWays(new int[]{1,1,1,1,1}, 3);
        System.out.println(result);
    }
}
