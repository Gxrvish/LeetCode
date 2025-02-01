class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int answer = 1; 
        
        for (int a : arr) {
            int beforeA = dp.getOrDefault(a - difference, 0); // Get previous sequence length
            dp.put(a, beforeA + 1); // Extend or start new sequence
            answer = Math.max(answer, dp.get(a)); // Track the max length
        }
        
        return answer;
    }
}
