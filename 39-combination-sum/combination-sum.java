import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>(); // This will store all the valid combinations
        findCombinations(0, candidates, target, ans, new ArrayList<>()); // Start backtracking from index 0
        return ans; // Return the final list of combinations
    }

    private void findCombinations(int index, int[] candidates, int target, List<List<Integer>> ans, List<Integer> current) {
        // Base Case: If the target becomes 0, we found a valid combination
        if (target == 0) {
            ans.add(new ArrayList<>(current)); // Add a copy of 'current' list to the answer
            return; // Stop further recursion
        }
        
        // Base Case: If we go out of bounds OR the target becomes negative, stop recursion
        if (index == candidates.length || target < 0) return;

        // **Choice 1: Pick the current element**
        current.add(candidates[index]); // Include the current element in the combination
        findCombinations(index, candidates, target - candidates[index], ans, current); // Recurse with reduced target
        current.remove(current.size() - 1); // Undo the choice (Backtracking)

        // **Choice 2: Skip the current element and move to the next index**
        findCombinations(index + 1, candidates, target, ans, current);
    }
}
