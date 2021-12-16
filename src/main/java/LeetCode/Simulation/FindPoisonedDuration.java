package LeetCode.Simulation;

public class FindPoisonedDuration {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        int result = n * duration;
        for (int i = 1; i < n; i++) {
            result -= Math.max(0, duration - (timeSeries[i] - timeSeries[i - 1]));
        }
        return result;
    }
}
