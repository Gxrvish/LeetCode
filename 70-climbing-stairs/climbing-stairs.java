class Solution {
    public int climbStairs(int n) {
        // Create a memo array to store results for steps 0 to n
        int[] memo = new int[n + 1];
        
        // Initialize all values as -1 (uncomputed)
        Arrays.fill(memo, -1);

        // Start from step 0
        return countWays(0, n, memo);
    }

    int countWays(int i, int n, int[] memo) {
        // \U0001f7e2 Base case: reached exactly step n — valid path
        if (i == n) return 1;

        // \U0001f534 Base case: stepped beyond n — invalid path
        if (i > n) return 0;

        // \U0001f4be If already computed, return stored result
        if (memo[i] != -1) return memo[i];

        // \U0001f9ed Explore both choices:
        // Take 1 step or 2 steps
        int oneStep = countWays(i + 1, n, memo);
        int twoStep = countWays(i + 2, n, memo);

        // \U0001f9ee Store the result for step i in memo
        memo[i] = oneStep + twoStep;

        return memo[i];
    }
}
