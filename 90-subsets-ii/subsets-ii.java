class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Sorting ensures that duplicates are together, which helps in skipping them later.
        Arrays.sort(nums);
        
        // Start backtracking from index 0 with an empty subset.
        backtrack(0, nums, result, new ArrayList<>());
        return result;
    }

    private void backtrack(int index, int[] nums, List<List<Integer>> result, List<Integer> currSub) {
        //  1. Store the current subset in the result list.
        // We make a new ArrayList because currSub is modified in recursion.
        if(!result.contains(currSub)) result.add(new ArrayList<>(currSub));

        //  2. Iterate over all remaining elements from 'index' to 'nums.length'
        for (int i = index; i < nums.length; i++) {
            
            //  3. Skip duplicate elements to avoid duplicate subsets.
            // This ensures that we only pick the first occurrence of a duplicate in each recursion level.
            //  4. Include the current element in the subset.
            currSub.add(nums[i]);

            //  5. Recur with the next index (i + 1) since each element is used at most once.
            backtrack(i + 1, nums, result, currSub);            

            //  6. Backtrack: Remove the last added element before moving to the next iteration.
            // This undoes the last choice to explore other possibilities.
            currSub.remove(currSub.size() - 1);
        }
    }
}