class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Initialize with a large value
        dp[0] = 0; // Base case: 0 coins to make amount 0

        // Iterate through all amounts
        for (int coin : coins) { // Outer loop iterates through coins
            for (int i = coin; i <= amount; i++) { // Start from 'coin' to avoid negative indices
                dp[i] = Math.min(dp[i], dp[i - coin] + 1); // Transition relation
            }
        }

        return dp[amount] > amount ? -1 : dp[amount]; // Return -1 if no solution
    }
}
