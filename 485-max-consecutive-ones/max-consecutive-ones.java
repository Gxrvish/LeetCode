class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxChunk = 0;
        int currChunk = 0;
        for(int i = 0; i< nums.length; i++) {
            if(nums[i] == 1) {
                currChunk++;
            } else {
                maxChunk = Math.max(currChunk, maxChunk);
                currChunk = 0;
            }
        }
        return Math.max(currChunk, maxChunk);
    }
}