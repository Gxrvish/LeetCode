class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList();
        int[] max_b_frequencies = new int[26];

        for(int i = 0; i<words2.length; i++) {
            String current_word = words2[i];
            int[] char_frequencies = get_char_frequency(current_word);

            for(int j=0; j<26; j++) {
                max_b_frequencies[j] = Math.max(max_b_frequencies[j], char_frequencies[j]);
            }
        }

        for(int i=0; i<words1.length; i++) {
            String current_word = words1[i];
            int[] char_counts = get_char_frequency(current_word);

            boolean valid = true;
            for(int j=0; j<26; j++) {
                if(max_b_frequencies[j] > char_counts[j]) {
                    valid = false;
                    break;
                }
            }
            if(valid) result.add(current_word);
        }
        return result;
    }
    public int[] get_char_frequency(String S) {
        int[] result = new int[26];
        for(char c : S.toCharArray()) {
            result[c-'a']++;
        }
        return result;
    }
}