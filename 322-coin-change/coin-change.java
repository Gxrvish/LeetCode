class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        Integer[][] dp = new Integer[coins.length][amount + 1];
        minCoins(0, coins, amount, dp);
        int result = minCoins(0, coins, amount, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int minCoins(int i, int[] coins, int amount, Integer[][] dp) {
        // Base case: exact change made
        if (amount == 0) return 0;

        // Base case: invalid state
        if (i == coins.length || amount < 0) return Integer.MAX_VALUE;
        if (dp[i][amount] != null) return dp[i][amount];
        // Option 1: pick current coin (only if amount >= coin value)
        int pick = Integer.MAX_VALUE;
        if (coins[i] <= amount) {
            int res = minCoins(i, coins, amount - coins[i], dp);
            if (res != Integer.MAX_VALUE) {
                pick = 1 + res;
            }
        }

        // Option 2: skip current coin
        int skip = minCoins(i + 1, coins, amount, dp);

        // Return the minimum of picking or skipping the coin
        return dp[i][amount] = Math.min(pick, skip);
    }
}
