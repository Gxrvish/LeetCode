class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        // Sort the words array by length
        Arrays.sort(words, Comparator.comparingInt(String::length));

        // Compare each word with all subsequent words
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break; // No need to check further once a match is found
                }
            }
        }
        return ans;
    }
}
