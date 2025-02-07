class Solution {

    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];

        // HashMap to store the color of each ball
        Map<Integer, Integer> ballColors = new HashMap<>();
        // HashMap to count how many balls have a specific color
        Map<Integer, Integer> colorCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int newColor = queries[i][1];

            // Check if this ball already has a color
            if (ballColors.containsKey(ball)) {
                int oldColor = ballColors.get(ball);
                // Decrease count of old color
                colorCount.put(oldColor, colorCount.get(oldColor) - 1);
                // Remove color from map if no balls have it
                if (colorCount.get(oldColor) == 0) {
                    colorCount.remove(oldColor);
                }
            }

            // Assign the new color to the ball
            ballColors.put(ball, newColor);
            // Increase count of the new color
            colorCount.put(newColor, colorCount.getOrDefault(newColor, 0) + 1);

            // Store the current count of distinct colors
            result[i] = colorCount.size();
        }

        return result;
    }
}
