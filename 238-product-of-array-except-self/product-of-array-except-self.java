class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] suffix = new int[nums.length];
        int[] prefix = new int[nums.length];
        for(int i = 0; i<nums.length; i++) {
            suffix[i] = 1;
            prefix[i] = 1;
        }
        suffix[0] = nums[0];
        prefix[nums.length-1] = nums[nums.length-1];
        for(int i = 1; i < nums.length; i++) {
            suffix[i] = nums[i] * suffix[i - 1];
        }
        for(int i = nums.length-2; i>0; i--) {
            prefix[i] *= nums[i] * prefix[i + 1];
        }
        for(int i = 1; i < nums.length - 1; i++) {
            nums[i] = suffix[i - 1] * prefix[i + 1];
        }
        nums[0] = prefix[1];
        nums[nums.length - 1] = suffix[nums.length-2];
        return nums;
    }
}