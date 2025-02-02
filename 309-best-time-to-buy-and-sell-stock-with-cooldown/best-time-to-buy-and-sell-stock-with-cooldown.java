class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int n = prices.length;
        int[] hold = new int[n];
        int[] sold = new int[n];
        int[] rest = new int[n];

        hold[0] = -prices[0];  // Buying the stock
        sold[0] = 0;           // No profit from selling initially
        rest[0] = 0;           // No profit from cooldown initially

        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i-1], rest[i-1] - prices[i]);
            sold[i] = hold[i-1] + prices[i];
            rest[i] = Math.max(rest[i-1], sold[i-1]);
        }

        // Maximum profit comes from either selling or resting
        return Math.max(sold[n-1], rest[n-1]);
    }
}
