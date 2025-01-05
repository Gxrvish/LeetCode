class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        // Convert the string to a character array for easier manipulation
        char[] arr = s.toCharArray();
        
        // Initialize a difference array (map) with one extra space to handle boundary updates
        int[] map = new int[arr.length + 1];
        
        // Process each shift operation in the shifts array
        for (int[] num : shifts) {
            if (num[2] == 0) {
                // If the shift direction is 0 (left), decrement at the start and increment after the end
                map[num[0]] -= 1;
                map[num[1] + 1] += 1;
            } else {
                // If the shift direction is 1 (right), increment at the start and decrement after the end
                map[num[0]] += 1;
                map[num[1] + 1] -= 1;
            }
        }
        
        // Initialize a cumulative sum to calculate net shifts at each position
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            // Update the cumulative sum for the current position
            sum += map[i];
            
            // Calculate the new character after applying the shift
            int n = ((arr[i] - 'a') + sum) % 26;
            if (n < 0) n += 26; // Ensure the result is non-negative
            
            // Update the character in the array
            arr[i] = (char) (n + 'a');
        }
        
        // Convert the character array back to a string and return the result
        return new String(arr);
    }
}
