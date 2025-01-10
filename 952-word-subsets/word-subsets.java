import java.util.*;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // Step 1: Compute maxBCount for all words in words2
        int[] maxBCount = new int[26];
        for (String word : words2) {
            int[] bCount = countFrequency(word);
            for (int i = 0; i < 26; i++) {
                maxBCount[i] = Math.max(maxBCount[i], bCount[i]);
            }
        }

        // Step 2: Filter words1 based on maxBCount
        List<String> result = new ArrayList<>();
        for (String word : words1) {
            int[] aCount = countFrequency(word);
            if (isUniversal(aCount, maxBCount)) {
                result.add(word);
            }
        }
        
        return result;
    }

    // Helper method to compute frequency of each character in a string
    private int[] countFrequency(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        return count;
    }

    // Helper method to check if aCount satisfies maxBCount
    private boolean isUniversal(int[] aCount, int[] maxBCount) {
        for (int i = 0; i < 26; i++) {
            if (aCount[i] < maxBCount[i]) {
                return false;
            }
        }
        return true;
    }
}
