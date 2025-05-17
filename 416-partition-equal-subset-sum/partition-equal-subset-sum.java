class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n][target + 1];
        // Base case: Any index can make sum 0 (by picking nothing)
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        // Base case: First element alone can make nums[0] if it's within target
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                boolean notPick = dp[i - 1][j];
                boolean pick = false;
                if (j >= nums[i]) {
                    pick = dp[i - 1][j - nums[i]];
                }
                dp[i][j] = pick || notPick;
            }
        }
        return dp[n - 1][target];
    }
}
