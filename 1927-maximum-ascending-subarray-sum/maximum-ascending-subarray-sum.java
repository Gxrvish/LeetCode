class Solution {
    public int maxAscendingSum(int[] nums) {
        int[] dp = new int[nums.length];
        for(int num:dp) {num=0;}
        dp[0] = nums[0];

        for(int i=1; i<nums.length; i++) {
            if(nums[i-1] < nums[i]) {
                dp[i] = dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        int max = -1;
        for(int num : dp) {
            max = Math.max(num, max);
        }

        return max;
    }
}