class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        path.append("(");
        backtrack(path, result, 1, 0, n);
        return result;
    }
    private void backtrack(StringBuilder path, List<String> result, int open, int close, int n) {
        if(path.length() == n*2) {
            result.add(path.toString());
            return;
        }
        if (open < n) {
            path.append('(');
            backtrack(path, result, open + 1, close, n);
            path.deleteCharAt(path.length() - 1);
        }
        if (close < open) {
            path.append(')');
            backtrack(path, result, open, close + 1, n);
            path.deleteCharAt(path.length() - 1);
        }
    }
}