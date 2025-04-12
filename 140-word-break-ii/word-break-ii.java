class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        backtrack(s, wordDict, result, 0, new StringBuilder());
        return result;
    }
    private void backtrack(String s, List<String> dict, List<String> res, int pos, StringBuilder curr) {
        if(pos == s.length()) {
            res.add(curr.toString());
            return;
        }

        for(int end = pos + 1; end <= s.length(); end++) {
            String word = s.substring(pos, end);
            if(dict.contains(word)) {
                int len = curr.length();
                curr.append(word);
                if (end < s.length()) curr.append(" ");
                backtrack(s, dict, res, end, curr);
                curr.setLength(len); // backtrack
            }
        }
    }
}