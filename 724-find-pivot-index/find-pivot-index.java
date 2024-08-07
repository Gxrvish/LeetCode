class Solution {
    public int pivotIndex(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 0;
        int[] right = new int[nums.length];
        right[nums.length - 1] = 0;
        for(int i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] + left[i-1];
        }
        for(int i = nums.length - 2; i >= 0; i--) {
            right[i] = nums[i + 1] + right[i+1];
        }
        for(int i = 0; i < nums.length; i++) {
            if(left[i] == right[i]) {
                return i;
            }
        }
        return -1;
    }
}