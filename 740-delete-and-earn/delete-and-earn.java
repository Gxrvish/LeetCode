class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 1) return nums[0];
        // if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] points = new int[10001];
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++) {
            points[nums[i]] += nums[i];
        }
        
        int[] dp = new int[10001];
        dp[0] = points[0];
        dp[1] = points[1];
        for(int i=2; i<=10000; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + points[i]);
        }
        return dp[10000];
    }
}