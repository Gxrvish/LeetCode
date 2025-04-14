class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        // Create a dp array where dp[i] means min cost to reach step i
        int[] dp = new int[n];

        // Base cases: we can step onto 0 or 1 directly
        dp[0] = cost[0];
        dp[1] = cost[1];

        // Build the answer for all steps from 2 to n-1
        for (int i = 2; i < n; i++) {
            // To reach step i, come from i-1 or i-2 (whichever is cheaper)
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        // You can reach the top from either of the last two steps
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
