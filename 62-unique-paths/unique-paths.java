class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // Initialize all cells as unvisited (-1)
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return countPath(0, 0, m, n, dp);
    }

    public int countPath(int i, int j, int m, int n, int[][] dp) {
        // If out of bounds, return 0 (invalid path)
        if (i >= m || j >= n) return 0;

        // If we reach the bottom-right cell, that's one valid path
        if (i == m - 1 && j == n - 1) return 1;

        // If this subproblem is already solved, return stored result
        if (dp[i][j] != -1) return dp[i][j];

        // Explore both right and down moves
        int down = countPath(i + 1, j, m, n, dp);
        int right = countPath(i, j + 1, m, n, dp);

        // Store the result in dp array
        dp[i][j] = down + right;

        return dp[i][j];
    }
}
