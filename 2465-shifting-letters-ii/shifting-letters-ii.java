class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diffArray = new int[n + 1]; // Extra space to avoid boundary checks

        // Update the difference array based on shifts
        for (int[] shift : shifts) {
            int start = shift[0], end = shift[1], direction = shift[2];
            diffArray[start] += (direction == 1 ? 1 : -1);
            diffArray[end + 1] -= (direction == 1 ? 1 : -1);
        }

        // Compute the cumulative shifts
        int netShift = 0;
        char[] result = s.toCharArray();

        for (int i = 0; i < n; i++) {
            netShift = (netShift + diffArray[i]) % 26;
            if (netShift < 0) netShift += 26; // Handle negative shifts
            result[i] = (char) ('a' + (result[i] - 'a' + netShift) % 26);
        }

        return new String(result);
    }
}
