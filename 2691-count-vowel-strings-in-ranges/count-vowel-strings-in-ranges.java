class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] str = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) {
                str[i] = 1;
            } else {
                str[i] = 0;
            }
        }
        
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + str[i];
        }
        
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0], right = queries[i][1];
            ans[i] = prefix[right + 1] - prefix[left];
        }
        
        return ans;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
