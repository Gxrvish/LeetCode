class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, 0, target, 0);
        return count;
    }
    private void backtrack(int[] nums, int i, int target, int sum) {
        if(i == nums.length) {
            if(sum == target) count++;
            return;
        }
        backtrack(nums, i + 1, target, sum + nums[i]);
        backtrack(nums, i + 1, target, sum - nums[i]);
    }
}