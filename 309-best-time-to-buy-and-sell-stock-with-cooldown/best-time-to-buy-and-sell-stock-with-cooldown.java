class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int hold = -prices[0]; // Profit when holding stock
        int sold = 0; // Profit when selling stock
        int rest = 0; // Profit when resting

        for (int i = 1; i < prices.length; i++) {
            int prevHold = hold;
            hold = Math.max(hold, rest - prices[i]); // Either keep holding or buy new stock
            rest = Math.max(rest, sold); // Rest: do nothing or come from sold
            sold = prevHold + prices[i]; // Sell the stock
        }

        return Math.max(sold, rest); // Maximum profit is in sold or rest
    }
}
