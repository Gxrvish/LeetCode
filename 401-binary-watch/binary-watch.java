class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        // Binary values for 10 LEDs: 4 for hours, 6 for minutes
        int[] leds = {8, 4, 2, 1, 32, 16, 8, 4, 2, 1};
        List<String> result = new ArrayList<>();
        
        // Start backtracking from LED index 0
        backtrack(result, 0, 0, turnedOn, 0, leds, 0);
        return result;
    }

    /**
     * @param r - list to collect valid time strings
     * @param hourC - current hour total
     * @param minuteC - current minute total
     * @param turnedOn - total LEDs to turn on
     * @param k - count of LEDs turned on so far
     * @param leds - values of each LED
     * @param start - starting index to avoid reusing LEDs
     */
    private void backtrack(List<String> r, int hourC, int minuteC, int turnedOn, int k, int[] leds, int start) {
        // Base condition: if required number of LEDs are turned on
        if (k == turnedOn) {
            if (hourC < 12 && minuteC < 60) {
                // Format valid time and add to result
                StringBuilder path = new StringBuilder();
                path.append(hourC).append(":");
                if (minuteC < 10) path.append("0");
                path.append(minuteC);
                r.add(path.toString());
            }
            return;
        }

        // Try all unused LEDs starting from 'start' index
        for (int i = start; i < leds.length; i++) {
            if (i < 4) { // LEDs 0-3 control hour
                hourC += leds[i];
                backtrack(r, hourC, minuteC, turnedOn, k + 1, leds, i + 1);
                hourC -= leds[i]; // backtrack
            } else { // LEDs 4-9 control minutes
                minuteC += leds[i];
                backtrack(r, hourC, minuteC, turnedOn, k + 1, leds, i + 1);
                minuteC -= leds[i]; // backtrack
            }
        }
    }
}
