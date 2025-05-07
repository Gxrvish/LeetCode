class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] obb: dp) {
            Arrays.fill(obb, -1);
        }
        return allWays(0, 0, obstacleGrid, dp);
    }
    public int allWays(int i, int j, int[][] arr, int[][] dp) {
        if(i >= arr.length || j >= arr[0].length) return 0;
        if(arr[i][j] != 0) return 0;
        if(i == arr.length-1 && j == arr[0].length-1) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        dp[i][j] = allWays(i+1, j, arr, dp) + allWays(i, j+1, arr, dp);
        return dp[i][j];
    }
}