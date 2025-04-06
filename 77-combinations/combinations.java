class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        // Start backtracking from 1 since we choose numbers from 1 to n
        backtrack(n, k, result, new ArrayList<>(), 1);
        return result;
    }

    // currCombi stores current combination being built
    // index is the starting point in each recursive call to ensure elements are used only once
    private void backtrack(int n, int k, List<List<Integer>> result, List<Integer> currCombi, int index) {
        // ✅ Base case: if combination is of length k, add it to result
        if (currCombi.size() == k) {
            result.add(new ArrayList<>(currCombi)); // must clone to avoid mutation
            return;
        }

        // \U0001f4a1 We iterate from 'index' to 'n' to avoid duplicates and preserve order
        for (int i = index; i <= n; i++) {
            // Choose
            currCombi.add(i);

            // Explore (i + 1 ensures the next number is always greater — prevents repetition)
            backtrack(n, k, result, currCombi, i + 1);

            // Un-choose (Backtrack)
            currCombi.remove(currCombi.size() - 1);
        }
    }
}
