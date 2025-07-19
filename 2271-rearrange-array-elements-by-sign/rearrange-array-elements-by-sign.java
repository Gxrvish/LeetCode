class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int idnx = 1;
        int idpx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ans[idpx] = nums[i];
                idpx += 2;
            } else {
                ans[idnx] = nums[i];
                idnx += 2;
            }
        }
        return ans;
    }
}