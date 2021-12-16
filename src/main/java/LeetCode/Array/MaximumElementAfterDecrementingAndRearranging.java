package LeetCode.Array;

import java.util.Arrays;
import java.util.Collections;

public class MaximumElementAfterDecrementingAndRearranging {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] cnt = new int[n];
        for (int item : arr) {
            if (item > n) {
                item = n;
            }
            cnt[item - 1]++;
        }
        int miss = 0;
        for (int i = 0; i < n; i++) {
            if (cnt[i] == 0) {
                miss++;
            } else {
                miss -= cnt[i] - 1;
                miss = Math.max(miss, 0);
            }
        }
        return n - miss;
    }

    public static void main(String[] args) {
        MaximumElementAfterDecrementingAndRearranging m = new MaximumElementAfterDecrementingAndRearranging();
        int result = m.maximumElementAfterDecrementingAndRearranging(new int[]{2, 2, 1, 2, 1});
        System.out.println(result);
    }

}
