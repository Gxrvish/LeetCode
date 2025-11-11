class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        // find first index 'i' where nums[i] < nums[i + 1], scanning from right
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        
        // if no such index, reverse to smallest permutation
        if (i < 0) {
            Arrays.sort(nums);
            return;
        }

        // find smallest number on right of i that’s > nums[i]
        int j = n - 1;
        while (nums[j] <= nums[i]) j--;
        
        // swap them
        swap(nums, i, j);
        
        // sort (or reverse) the suffix after i
        Arrays.sort(nums, i + 1, n);
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
