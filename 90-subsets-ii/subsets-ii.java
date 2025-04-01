class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array to bring duplicates together
        backtrack(0, nums, result, new ArrayList<>());
        return result;
    }

    private void backtrack(int index, int[] nums, List<List<Integer>> result, List<Integer> currSub) {
        result.add(new ArrayList<>(currSub)); // Directly add the current subset

        for (int i = index; i < nums.length; i++) {
            // ✅ Skip duplicates by ensuring we only pick the first occurrence at the same recursion level
            if (i > index && nums[i] == nums[i - 1]) continue;

            currSub.add(nums[i]); // Include the current element
            backtrack(i + 1, nums, result, currSub); // Recur to pick the next elements
            currSub.remove(currSub.size() - 1); // Undo choice (backtrack)
        }
    }
}