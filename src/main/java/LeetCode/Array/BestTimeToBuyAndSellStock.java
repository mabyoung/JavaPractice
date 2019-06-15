package LeetCode.Array;

/**
 * Say you have an array for which the i th element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction
 * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices){
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        for (int price : prices) {
            buy = Math.max(buy, -price);
            sell = Math.max(sell, buy+price);
        }
        return sell;
    }
}
