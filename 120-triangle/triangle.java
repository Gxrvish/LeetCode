class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int l = triangle.size();
        int[] dp = new int[l];
        for(int i = 0; i < l; i++) {
            dp[i] = triangle.get(l-1).get(i);
        }
        for(int i = l-2; i>=0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
}