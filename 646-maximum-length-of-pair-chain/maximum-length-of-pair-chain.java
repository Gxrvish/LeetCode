class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1])); // Sort by the second value
        int output = 0;
        int currentEnd = Integer.MIN_VALUE; // Track the end of the last selected pair

        for (int[] pair : pairs) {
            if (pair[0] > currentEnd) { // If the current pair can be added to the chain
                output++;
                currentEnd = pair[1]; // Update the end value
            }
        }

        return output;
    }
}
