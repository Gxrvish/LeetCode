class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int hold = -prices[0];  // Initially, we buy the stock
        int cash = 0;  // No profit if we don't buy any stock

        for (int i = 1; i < n; i++) {
            int newHold = Math.max(hold, cash - prices[i]);  // Either keep holding, or buy today
            int newCash = Math.max(cash, hold + prices[i] - fee);  // Either keep cash, or sell today (after fee)
            
            hold = newHold;
            cash = newCash;
        }

        return cash;  // Maximum profit when we don't hold a stock at the last day
    }
}
