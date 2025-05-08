class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] hey : dp) {
            Arrays.fill(hey, -1);
        }
        return countMin(0, 0, grid, dp);
    }

    public int countMin(int i, int j, int[][] grid, int[][] dp) {
        int m = grid.length, n = grid[0].length;
        // base case: out of bounds
        if (i >= m || j >= n) return Integer.MAX_VALUE;

        // base case: destination cell
        if (i == m - 1 && j == n - 1) return grid[i][j];

        if(dp[i][j] != -1) return dp[i][j];

        // recursive calls to right and down
        int right = countMin(i, j + 1, grid, dp);
        int down = countMin(i + 1, j, grid, dp);

        return dp[i][j] = grid[i][j] + Math.min(right, down);
    }
}
