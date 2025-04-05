class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Sort the array so that duplicates are adjacent
        Arrays.sort(nums);

        // 'used' array keeps track of which elements have been included so far
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);

        // Begin backtracking with an empty permutation
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> currPermu, List<List<Integer>> result) {
        // Base case: if we've used all numbers, add the permutation to result
        if (currPermu.size() == nums.length) {
            result.add(new ArrayList<>(currPermu)); // Make a copy
            return;
        }

        // Loop through all numbers to try each unused one at this position
        for (int i = 0; i < nums.length; i++) {
            // Skip this number if it was already used in the current path
            if (used[i]) continue;

            // Skip duplicates: if this number is same as previous and previous is not used, skip it
            // This ensures that we only pick the *first* instance of the duplicate at the current level
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            // Choose this number: add to current permutation and mark as used
            currPermu.add(nums[i]);
            used[i] = true;

            // Recurse to build the next position
            backtrack(nums, used, currPermu, result);

            // Backtrack: remove the number and mark it as unused
            currPermu.remove(currPermu.size() - 1);
            used[i] = false;
        }
    }
}
