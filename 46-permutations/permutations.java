class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 'used' array keeps track of which numbers are already included in the current permutation
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false); // initially no number is used

        // Start backtracking with an empty permutation
        backtrack(used, nums, result, new ArrayList<>(), 0);
        return result;
    }

    // Backtracking function to build permutations
    private void backtrack(boolean[] used, int[] nums, List<List<Integer>> result, List<Integer> currPermu, int start) {
        // Base case: if the current permutation has reached full length
        if (currPermu.size() == nums.length) {
            // Add a copy of the current permutation to the result list
            // Important: use 'new ArrayList<>()' to copy because 'currPermu' will be modified further
            result.add(new ArrayList<>(currPermu));
            return;
        }

        // Explore all possible numbers to place at current position
        for (int i = 0; i < nums.length; i++) {
            // Only consider numbers that haven’t been used in the current path
            if (!used[i]) {
                // Choose: add the number to current permutation and mark it as used
                currPermu.add(nums[i]);
                used[i] = true;

                // Recurse: build the next level of the permutation
                backtrack(used, nums, result, currPermu, i + 1);

                // Backtrack: remove the number and mark it as unused for other possibilities
                currPermu.remove(currPermu.size() - 1);
                used[i] = false;
            }
        }
    }
}
