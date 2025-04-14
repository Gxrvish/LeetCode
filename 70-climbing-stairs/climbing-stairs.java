class Solution {
    public int climbStairs(int n) {
        // \U0001f7e2 Base case:
        // From step n, there's only 1 way (you're already at the top)
        int oneStepAhead = 1;  // Represents dp[i + 1]
        int twoStepsAhead = 0; // Represents dp[i + 2]

        // \U0001f501 Start from step n - 1 and move backward to step 0
        for (int i = n - 1; i >= 0; i--) {
            // \U0001f9ee Total ways from step i = ways from (i + 1) + ways from (i + 2)
            int current = oneStepAhead + twoStepsAhead;

            // \U0001f501 Move the window one step backward
            twoStepsAhead = oneStepAhead;   // dp[i + 2] ← dp[i + 1]
            oneStepAhead = current;         // dp[i + 1] ← current dp[i]
        }

        // \U0001f3c1 oneStepAhead now stores dp[0], i.e., ways from step 0
        return oneStepAhead;
    }
}
