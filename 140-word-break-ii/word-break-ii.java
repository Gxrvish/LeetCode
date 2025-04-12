class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        
        // Start backtracking from position 0 with an empty path
        backtrack(s, wordDict, result, 0, new StringBuilder());
        
        return result;
    }

    private void backtrack(String s, List<String> dict, List<String> res, int pos, StringBuilder curr) {
        // Base case: If we have reached the end of the string, it means we found a valid sentence
        if(pos == s.length()) {
            // Add the current path (built sentence) to the result list
            res.add(curr.toString());
            return;
        }

        // Try every possible end index from the current position
        for(int end = pos + 1; end <= s.length(); end++) {
            // Extract the substring from current position to the 'end' position
            String word = s.substring(pos, end);
            
            // If this substring exists in the dictionary, we consider it a valid word
            if(dict.contains(word)) {
                // Save the current length of the StringBuilder before appending
                // This is needed so we can undo (backtrack) after the recursive call
                int len = curr.length();

                // Append the valid word to the sentence
                curr.append(word);
                
                // Add a space if we're not at the end of the string yet
                // (We don't want a trailing space at the end of the sentence)
                if (end < s.length()) curr.append(" ");

                // Recur for the remaining part of the string starting from 'end'
                backtrack(s, dict, res, end, curr);

                // Backtrack: remove the word and the space we added earlier
                curr.setLength(len);
            }
        }
    }
}
