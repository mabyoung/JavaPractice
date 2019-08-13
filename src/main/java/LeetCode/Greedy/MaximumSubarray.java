package LeetCode.Greedy;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example, given the array[−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray[4,−1,2,1]has the largest sum =6.
 *
 * click to show more practice.
 *
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        int sum = 0;
        int max = A[0];
        for (int item : A) {
            sum += item;
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int result = maximumSubarray.maxSubArray(new int[]{-1, 1, 2, 1});
        System.out.println(result);
    }
}
