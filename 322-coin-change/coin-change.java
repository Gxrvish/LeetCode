class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount + 1];
        // Base case: zero coins needed to make amount 0
        for (int i = 0; i < n; i++) dp[i][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                // Option 1: pick the current coin if j >= coins[i]
                int pick = Integer.MAX_VALUE;
                if (coins[i] <= j && dp[i][j - coins[i]] != null && dp[i][j - coins[i]] != Integer.MAX_VALUE) {
                    pick = 1 + dp[i][j - coins[i]];
                }
                // Option 2: skip the current coin (only if i > 0)
                int skip = (i > 0 && dp[i - 1][j] != null) ? dp[i - 1][j] : Integer.MAX_VALUE;
                // Take the minimum of pick and skip
                dp[i][j] = Math.min(pick, skip);
            }
        }
        int result = dp[n - 1][amount];
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
