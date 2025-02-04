class Solution {
    public int maxAscendingSum(int[] nums) {
        int max=nums[0];
        int curr=max;
        for(int i=1; i<nums.length; i++) {
            if(nums[i-1] < nums[i]) {
                curr+=nums[i];
            } else {
                max=Math.max(curr, max);
                curr=nums[i];
            }
        }
        return Math.max(curr, max);
    }
}