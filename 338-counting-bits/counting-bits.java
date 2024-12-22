class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1]; // Array to store results for numbers from 0 to n
        dp[0] = 0; // Base case: 0 has no 1's in binary

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1); // Transition formula
        }

        return dp; // Return the result array
    }
}
