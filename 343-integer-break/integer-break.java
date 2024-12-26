class Solution {
    public int integerBreak(int n) {
        if (n <= 3) return n - 1; // Base case for small values of n

        int[] dp = new int[n + 1];
        dp[1] = 1;

        // Fill the dp array for all values from 2 to n
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // Calculate maximum by breaking i into j and i-j
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }
}
