class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        Boolean[][] dp = new Boolean[nums.length][target + 1];

        return isPartition(0, target, nums, dp);
    }

    public boolean isPartition(int i, int sum, int[] nums, Boolean[][] dp) {
        if (sum == 0) return true;
        if (i == nums.length || sum < 0) return false;

        if (dp[i][sum] != null) return dp[i][sum];

        boolean pick = isPartition(i + 1, sum - nums[i], nums, dp);
        boolean notPick = isPartition(i + 1, sum, nums, dp);

        dp[i][sum] = pick || notPick;
        return dp[i][sum];
    }
}
