class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentSum, int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(currentSum));
            return; // Important! Avoid unnecessary recursion.
        }
        if (target < 0) return;

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue; // Skip duplicates
            currentSum.add(candidates[i]);
            backtrack(result, currentSum, candidates, target - candidates[i], i + 1); // Fix here!
            currentSum.remove(currentSum.size() - 1); // Backtrack step
        }
    }
}
