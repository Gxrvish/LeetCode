class Solution {
    public void moveZeroes(int[] nums) {
        int baby = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[baby] = nums[i];
                baby++;
            }
        }
        for(int i = baby; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}