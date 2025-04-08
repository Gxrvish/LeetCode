class Solution {

    public List<String> generateParenthesis(int n) {
        // Result list to store all valid combinations of parentheses
        List<String> result = new ArrayList<>();

        // StringBuilder to efficiently build current parenthesis string
        StringBuilder path = new StringBuilder();

        // We always start with one open bracket as the first character
        path.append("(");

        // Start backtracking with:
        // open = 1 (we’ve used one '('),
        // close = 0 (we haven’t used any ')'),
        // n = total pairs we want.
        backtrack(path, result, 1, 0, n);
        return result;
    }

    /**
     * Backtracking function to build valid combinations.
     *
     * @param path    current partial string (being built)
     * @param result  final list of valid combinations
     * @param open    number of open brackets used so far
     * @param close   number of close brackets used so far
     * @param n       total number of bracket pairs allowed
     */
    private void backtrack(StringBuilder path, List<String> result, int open, int close, int n) {
        // Base condition: If we've used all 2*n characters
        if (path.length() == n * 2) {
            result.add(path.toString());  // Store the current valid combination
            return;
        }

        // Choice 1: Add an open bracket if we still have some left
        if (open < n) {
            path.append('(');  // Choose
            backtrack(path, result, open + 1, close, n);  // Explore
            path.deleteCharAt(path.length() - 1);  // Un-choose (backtrack)
        }

        // Choice 2: Add a close bracket only if it won't unbalance the expression
        if (close < open) {
            path.append(')');
            backtrack(path, result, open, close + 1, n);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
