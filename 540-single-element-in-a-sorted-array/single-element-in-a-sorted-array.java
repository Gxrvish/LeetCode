class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            // force mid to be even
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) {
                // pair is correct -> single is on right
                l = mid + 2;
            } else {
                // pair is broken -> single is on left (or mid)
                r = mid;
            }
        }
        return nums[l];
    }
}
