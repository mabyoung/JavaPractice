package LeetCode.Array;

public class NumSearch {
    public int search(int[] nums, int target) {
        if (nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        int begin = left;
        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int end = right;
        if (nums[begin] == target) {
            begin--;
        }
        if (end < nums.length && nums[end] == target){
            end++;
        }
        return Math.max(0, end - begin - 1);
    }


    public static void main(String[] args) {
        NumSearch numSearch = new NumSearch();
        int result = numSearch.search(new int[]{}, 1);
        System.out.println(result);
    }
}
