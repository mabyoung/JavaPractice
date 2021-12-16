package LeetCode.Array;

public class SumOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + arr[i];
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if ((j - i) % 2 == 0) {
                    result += sum[j + 1] - sum[i];
                }
            }
        }
        return result;
    }
}
