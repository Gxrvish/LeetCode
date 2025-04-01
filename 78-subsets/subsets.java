class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Start backtracking from index 0 with an empty subset.
        backtrack(0, nums, result, new ArrayList<>());

        return result; // Return the final list containing all subsets.
    }

    private void backtrack(int index, int[] nums, List<List<Integer>> result, List<Integer> currSub) {
        // Step 1: Add the current subset to the result list.
        // A new ArrayList is created to avoid modification in recursive calls.
        result.add(new ArrayList<>(currSub));

        // Step 2: Iterate through all remaining elements starting from the current index.
        for (int i = index; i < nums.length; i++) {
            // Step 3: Include the current element in the subset.
            currSub.add(nums[i]);

            // Step 4: Recur to generate further subsets, moving to the next index.
            // Each element can only be used once per subset, so we pass i + 1.
            backtrack(i + 1, nums, result, currSub);

            // Step 5: Backtrack by removing the last element added.
            // This step is necessary to explore other possible subsets.
            currSub.remove(currSub.size() - 1);
        }
    }
}