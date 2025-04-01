class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), result);
        return result;
    }
    
    // Backtracking function to explore all possible partitions
    private void backtrack(int index, String s, List<String> currentPartition, List<List<String>> result) {
        // Base Case: If we have reached the end of the string, add the current partition to the result
        if (index == s.length()) {
            result.add(new ArrayList<>(currentPartition)); // Store a copy of currentPartition
            return;
        }
        
        // Iterate over all possible substrings starting from 'index'
        for (int i = index; i < s.length(); i++) {
            // Check if the substring s[index...i] is a palindrome
            if (isPalindrome(s, index, i)) {
                // If it is, add it to the current partition
                currentPartition.add(s.substring(index, i + 1));
                
                // Recur for the remaining substring
                backtrack(i + 1, s, currentPartition, result);
                
                // Backtrack: Remove the last added substring before moving to the next iteration
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }
    
    // Function to check if a given substring s[left...right] is a palindrome
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false; // If characters don't match, it's not a palindrome
            }
            left++;
            right--;
        }
        return true; // If the loop completes, it's a palindrome
    }
}