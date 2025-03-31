class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    private void findCombinations(int index, int[] candidates, int target, List<List<Integer>> ans, List<Integer> current) {
        if (target == 0) {
            ans.add(new ArrayList<>(current)); // Found a valid combination
            return;
        }
        if (index == candidates.length || target < 0) return; // Base case

        // Pick the current number (same index can be used again)
        current.add(candidates[index]);
        findCombinations(index, candidates, target - candidates[index], ans, current);
        current.remove(current.size() - 1); // Backtrack

        // Skip the current number and move to the next
        findCombinations(index + 1, candidates, target, ans, current);
    }
}
