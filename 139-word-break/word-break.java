class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Convert wordDict to HashSet for O(1) lookups
        Set<String> dict = new HashSet<>(wordDict);
        // Create a memoization map to store results of each index
        Map<Integer, Boolean> memo = new HashMap<>();
        
        return dfs(s, 0, dict, memo);
    }

    private boolean dfs(String s, int start, Set<String> dict, Map<Integer, Boolean> memo) {
        // If we reached the end of the string, it's a valid segmentation
        if (start == s.length()) return true;

        // If we have already computed this index, return the cached result
        if (memo.containsKey(start)) return memo.get(start);

        // Try every possible substring starting from index 'start'
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);

            // If this prefix exists in the dictionary
            if (dict.contains(word)) {
                // Recursively check for the remaining string
                if (dfs(s, end, dict, memo)) {
                    memo.put(start, true); // Cache the result
                    return true;
                }
            }
        }

        // Cache and return false if no valid segmentation found
        memo.put(start, false);
        return false;
    }
}
