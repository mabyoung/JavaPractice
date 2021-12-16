package LeetCode.Simulation;

import java.util.Arrays;

public class GetMaximumGenerated {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] array = new int[n + 1];
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                array[i] = array[i / 2];
            } else {
                array[i] = array[i / 2] + array[i / 2 + 1];
            }
        }
        return Arrays.stream(array).max().getAsInt();
    }


    public static void main(String[] args) {
        GetMaximumGenerated getMaximumGenerated = new GetMaximumGenerated();
        getMaximumGenerated.getMaximumGenerated(4);
    }
}
