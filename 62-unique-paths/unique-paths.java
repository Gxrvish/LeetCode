class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return countPath(0, 0, m, n, dp);
    }

    public int countPath(int i, int j, int m, int n, int[][] dp) {
        // If we reach the bottom-right cell, that's one valid path
        if (i == m - 1 && j == n - 1) return 1;

        // If out of bounds, return 0 (invalid path)
        if (i >= m || j >= n) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        // Move Down + Move Right
        int down = countPath(i + 1, j, m, n, dp);
        int right = countPath(i, j + 1, m, n, dp);
        dp[i][j] = down + right;
        return dp[i][j];
    }
}
