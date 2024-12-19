class Solution {
    public int numSquares(int n) {
        // Create a dp array to store the minimum number of perfect squares for each number
        int[] dp = new int[n + 1];

        // Initialize the dp array with a large value (infinity substitute)
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // Base case: 0 can be represented as 0 perfect squares
        dp[0] = 0;

        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}
