package LeetCode.Simulation;

import java.util.ArrayList;
import java.util.List;

public class MaxCompatibilitySum {

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int n = students.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = getCompatibilitySum(students[i], mentors[j]);
            }
        }
        int result = 0;
        for (int[] ints : getFullArray(n)) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += dp[i][ints[i] - 1];
            }
            if (sum > result) {
                result = sum;
            }
        }
        return result;
    }

    public int getCompatibilitySum(int[] student, int[] mentor) {
        int result = 0;
        for (int i = 0; i < student.length; i++) {
            if (student[i] == mentor[i]) {
                result++;
            }
        }
        return result;
    }

    public List<int[]> getFullArray(int n) {
        List<int[]> result = new ArrayList<>();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        result.add(array);
        long count = 1;
        for (int i = 2; i <= n; i++) {
            count *= i;
        }
        for (long i = 1; i < count; i++) {
            int[] next = getNext(array);
            result.add(next);
            array = next;
        }
        return result;
    }

    public int[] getNext(int[] array) {
        int n = array.length;
        int[] next = new int[n];
        System.arraycopy(array, 0, next, 0, n);
        int index = n - 1;
        while (index > 0 && next[index] < next[index - 1]) {
            index--;
        }
        if (index == 0) {
            revert(next, 0, n - 1);
            return next;
        }
        int target = index - 1;
        while (index < n && next[index] > next[target]) {
            index++;
        }
        int tmp = next[target];
        next[target] = next[index - 1];
        next[index - 1] = tmp;
        revert(next, target + 1, n - 1);
        return next;
    }

    public void revert(int[] array, int left, int right) {
        while (left < right) {
            int tmp = array[left];
            array[left++] = array[right];
            array[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        MaxCompatibilitySum maxCompatibilitySum = new MaxCompatibilitySum();
        int result = maxCompatibilitySum.maxCompatibilitySum(new int[][]{{0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 0, 1}, {1, 0, 1, 1, 0, 0}}, new int[][]{{1, 0, 0, 0, 0, 1}, {0, 1, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 1}
        });
        System.out.println(result);
    }
}
