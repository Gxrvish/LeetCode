class Solution {
    public int numTilings(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int mod = 1_000_000_007;

        // dp array to store the number of ways to tile
        long[] dp = new long[n + 1];

        // Base cases
        dp[1] = 1;
        dp[2] = 2;

        // Track the sum of dp values to handle tromino cases
        long sum = dp[1]; 

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + 2 * sum) % mod;
            sum = (sum + dp[i - 2]) % mod;
        }

        return (int) dp[n];
    }
}
