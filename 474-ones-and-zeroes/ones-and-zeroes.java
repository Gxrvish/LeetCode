class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int s = strs.length;
        int[][] countArr = new int[s][2];

        // Step 1: Count 0s and 1s in each string
        for (int i = 0; i < s; i++) {
            countArr[i][0] = (int) strs[i].chars().filter(c -> c == '0').count();
            countArr[i][1] = (int) strs[i].chars().filter(c -> c == '1').count();
        }

        // Step 2: Initialize DP table
        int[][] dp = new int[m + 1][n + 1];

        // Step 3: Fill the DP table
        for (int i = 0; i < s; i++) {
            int count0 = countArr[i][0];
            int count1 = countArr[i][1];

            // Update dp table in reverse order to avoid reusing the same string
            for (int x = m; x >= count0; x--) {
                for (int y = n; y >= count1; y--) {
                    dp[x][y] = Math.max(dp[x][y], dp[x - count0][y - count1] + 1);
                }
            }
        }

        // Step 4: Return the maximum number of strings
        return dp[m][n];
    }
}
