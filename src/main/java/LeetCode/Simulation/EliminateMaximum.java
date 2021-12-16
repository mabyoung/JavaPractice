package LeetCode.Simulation;

import java.util.Arrays;

public class EliminateMaximum {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] arriveTime = new int[n];
        for (int i = 0; i < n; i++) {
            arriveTime[i] = (int) Math.ceil((double) dist[i] / speed[i]);
        }
        Arrays.sort(arriveTime);
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (arriveTime[i] <= i) {
                return result;
            }
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        EliminateMaximum eliminateMaximum = new EliminateMaximum();
        int result = eliminateMaximum.eliminateMaximum(new int[]{3, 2, 4}, new int[]{5, 3, 2});
        System.out.println(result);
    }
}
