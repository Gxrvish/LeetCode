class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Start backtracking from index 0
        backtrack(nums, 0, result);
        return result;
    }

    // Backtracking by fixing one index at a time using swapping
    private void backtrack(int[] nums, int index, List<List<Integer>> result) {
        // Base case: if index has reached the end, store the current permutation
        if (index == nums.length) {
            List<Integer> currPermu = new ArrayList<>();
            for (int num : nums) {
                currPermu.add(num); // Copy array into list
            }
            if(!result.contains(currPermu)) result.add(currPermu);
            return;
        }

        // Try placing every number at the current index
        for (int i = index; i < nums.length; i++) {
            // Swap nums[i] to the current index position
            swap(nums, index, i);

            // Recurse to fix the next index
            backtrack(nums, index + 1, result);

            // Backtrack: undo the swap to restore original state
            swap(nums, index, i);
        }
    }

    // Swap helper function
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
