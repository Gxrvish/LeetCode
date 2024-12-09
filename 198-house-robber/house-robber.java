class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // Initialize two variables to track the previous two results
        int prev2 = nums[0]; // equivalent to dp[i-2]
        int prev1 = Math.max(nums[0], nums[1]); // equivalent to dp[i-1]

        // Iterate through the houses starting from the 3rd house
        for (int i = 2; i < n; i++) {
            int curr = Math.max(nums[i] + prev2, prev1); // Current state
            prev2 = prev1; // Shift prev2 to prev1
            prev1 = curr;  // Update prev1 to the current state
        }

        return prev1; // The last value is the maximum money robbed
    }
}
