package LeetCode.Simulation;

import java.util.Random;

public class Solution {
    int[] sum;

    public Solution(int[] w) {
        int n = w.length;
        sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + w[i];
        }
    }

    public int pickIndex() {
        int n = sum.length;
        int random = getRandom(1, sum[n - 1]);
        return getIndex(random);
    }

    public int getIndex(int target) {
        if (target < sum[1]) {
            return 0;
        }
        int left = 1;
        int right = sum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sum[mid] == target) {
                return mid - 1;
            } else if (sum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    public int getRandom(int left, int right) {
        Random random = new Random();
        return random.nextInt((right - left) + 1) + left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2});
        for (int i = 0; i < 100; i++) {
            int random = solution.pickIndex();
            System.out.println(random);
        }
    }
}
