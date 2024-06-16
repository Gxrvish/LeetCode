class Solution {
    public int minPatches(int[] nums, int n) {
        long maxRange = 0; // Use long to avoid integer overflow
        int patches = 0;
        int i = 0;

        while (maxRange < n) {
            if (i < nums.length && nums[i] <= maxRange + 1) {
                maxRange += nums[i];
                i++;
            } else {
                maxRange += maxRange + 1;
                patches++;
            }
        }

        return patches;
    }
}