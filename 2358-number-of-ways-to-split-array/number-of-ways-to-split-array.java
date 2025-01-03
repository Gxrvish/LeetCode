class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for(long num : nums) {
            sum += num;
        }

        long curr_sum = 0;
        int count = 0;
        for(int i=0; i<nums.length-1; i++) {
            curr_sum += nums[i];
            if(curr_sum >= (sum - curr_sum)) {
                count++;
            }
        }

        return count;
    }
}