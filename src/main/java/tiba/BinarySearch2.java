package tiba;

public class BinarySearch2 {
    public int search(int[] nums, int target) {
        int index = -1;
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] == target) {
                index = mid;
                end = mid - 1;
            }else if (nums[mid] < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        BinarySearch2 search = new BinarySearch2();
        int[] nums = new int[]{1, 2, 4, 4, 5};
        System.out.println(search.search(nums, 4));
    }
}
