class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int min_value = Integer.MAX_VALUE;
        int max_value = Integer.MIN_VALUE;
        int result = 0;

        // Find the minimum and maximum values in the array
        for (int tmp : arr) {
            if (tmp < min_value) min_value = tmp;
            if (tmp > max_value) max_value = tmp;
        }

        // Create a cache array to store the lengths of subsequences
        int[] cache = new int[max_value - min_value + 1];

        // Iterate through the array to find the longest subsequence
        for (int j : arr) {
            int tmp = j - min_value;
            int prev = j - difference;

            // Check if the previous element (j - difference) is within the bounds
            if (prev >= min_value && prev <= max_value) {
                cache[tmp] = cache[prev - min_value] + 1;
            } else {
                cache[tmp] = 1;
            }

            // Update the result with the maximum length found so far
            result = Math.max(result, cache[tmp]);
        }

        return result;
    }
}