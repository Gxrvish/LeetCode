class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int l = triangle.size();
        int[][] dp = new int[l][l];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return pickNotPick(triangle, 0, 0, dp); 
    }
    public int pickNotPick(List<List<Integer>> t, int i, int j, int[][] dp) {
        if(i == t.size() - 1) return t.get(i).get(j);
        if(dp[i][j] != -1) return dp[i][j];
        int down = pickNotPick(t, i + 1, j, dp);
        int diag = pickNotPick(t, i + 1, j + 1, dp);
        return dp[i][j] = t.get(i).get(j) + Math.min(down, diag);
    }
}