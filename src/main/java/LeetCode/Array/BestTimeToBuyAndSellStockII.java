package LeetCode.Array;

/**
 * Say you have an array for which the i th element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        int lastPrice = 0;
        int totalBonus = 0;
        for (int price : prices) {
            if (price < lastPrice) {
                totalBonus += sell;
                buy = Integer.MIN_VALUE;
                sell = 0;
            }
            buy = Math.max(buy, -price);
            sell = Math.max(sell, buy + price);
            lastPrice = price;
        }
        return totalBonus + sell;
    }
}
