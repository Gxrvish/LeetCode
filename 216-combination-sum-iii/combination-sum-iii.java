class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>(); // Stores the final valid combinations
        backtrack(1, k, n, new ArrayList<>(), result); // Start backtracking from number 1
        return result;
    }
    
    private void backtrack(int start, int k, int target, List<Integer> currentCombination, List<List<Integer>> result) {
        // Base case: If we have selected 'k' numbers and the target is exactly 0
        if (k == 0 && target == 0) {
            result.add(new ArrayList<>(currentCombination)); // Store the valid combination
            return;
        }
        
        // If k or target is invalid, stop exploring this path
        if (k == 0 || target < 0) {
            return;
        }
        
        // Iterate through numbers from 'start' to 9
        for (int i = start; i <= 9; i++) {
            currentCombination.add(i); // Choose the current number
            
            // Recur with next number, one less 'k', and reduced target
            backtrack(i + 1, k - 1, target - i, currentCombination, result);
            
            currentCombination.remove(currentCombination.size() - 1); // Backtrack (undo the last choice)
        }
    }
}
