package LeetCode.Simulation;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] min = new int[n];
        int[] max = new int[n];
        int minValue = prices[0];
        for (int i = 0; i < n; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            }
            min[i] = minValue;
        }
        int maxValue = prices[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (prices[i] > maxValue) {
                maxValue = prices[i];
            }
            max[i] = maxValue;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, max[i] - min[i]);
        }
        return result;
    }
}
