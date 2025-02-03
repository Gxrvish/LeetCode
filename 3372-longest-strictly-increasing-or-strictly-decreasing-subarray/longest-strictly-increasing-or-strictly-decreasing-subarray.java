class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxDec=1, maxInc=1;
        int dec = 1;
        int inc = 1;
        for(int i =1; i<nums.length; i++) {
            if(nums[i-1] < nums[i]) {
                inc++;
                maxInc = Math.max(maxInc, inc);
                dec=1;
            }
            else if(nums[i-1] > nums[i]) {
                dec++;
                maxDec = Math.max(maxDec, dec);
                inc=1;
            } else {
                inc=1;
                dec=1;
            }

        }
        return Math.max(maxInc, maxDec);
    }
}