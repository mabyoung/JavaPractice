package LeetCode.Array;

public class FindMiddleIndex {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            if (sum[n] - sum[i + 1] == sum[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindMiddleIndex findMiddleIndex = new FindMiddleIndex();
        int result = findMiddleIndex.findMiddleIndex(new int[]{1, -1, 4});
        System.out.println(result);
    }
}
