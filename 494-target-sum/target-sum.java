class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;

        // First, calculate the total sum of the array
        // This helps us determine the valid range of possible sums
        for (int num : nums) {
            totalSum += num;
        }

        // If the absolute value of target is more than totalSum,
        // it's impossible to reach target with any combination of + and -
        if (Math.abs(target) > totalSum) return 0;

        // DP table: dp[i][j] = number of ways to reach sum (j - totalSum) using first i numbers
        // Range of possible sums is from -totalSum to +totalSum, which maps to indices 0 to 2*totalSum
        int[][] dp = new int[nums.length + 1][2 * totalSum + 1];

        // Base case: There is 1 way to reach sum = 0 using 0 elements → do nothing
        // Offset sum 0 to index `totalSum` in array
        dp[0][totalSum] = 1;

        // Fill the DP table row by row
        for (int i = 1; i <= nums.length; i++) {
            int num = nums[i - 1]; // current number to consider

            // Try all possible sums from previous step
            for (int sum = -totalSum; sum <= totalSum; sum++) {
                // Convert actual sum to index in dp array using offset
                int prevIndex = sum + totalSum;

                // If current sum was reachable in previous step
                if (dp[i - 1][prevIndex] > 0) {
                    // Option 1: Add current number → sum becomes sum + num
                    int addIndex = sum + num + totalSum;
                    if (addIndex <= 2 * totalSum)
                        dp[i][addIndex] += dp[i - 1][prevIndex];

                    // Option 2: Subtract current number → sum becomes sum - num
                    int subtractIndex = sum - num + totalSum;
                    if (subtractIndex >= 0)
                        dp[i][subtractIndex] += dp[i - 1][prevIndex];
                }
            }
        }

        // Final result is number of ways to reach `target`, 
        // which is stored at index target + totalSum in last row
        return dp[nums.length][target + totalSum];
    }
}
