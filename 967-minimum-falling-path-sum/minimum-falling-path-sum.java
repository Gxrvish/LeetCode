class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int l = matrix.length;
        int[] dp = new int[l];
        for (int i = 0; i < l; i++) dp[i] = matrix[l - 1][i];

        for (int i = l - 2; i >= 0; i--) {
            int[] temp = new int[l];
            for (int j = 0; j < l; j++) {
                int left = (j > 0) ? dp[j - 1] : Integer.MAX_VALUE;
                int down = dp[j];
                int right = (j < l - 1) ? dp[j + 1] : Integer.MAX_VALUE;
                temp[j] = matrix[i][j] + Math.min(left, Math.min(down, right));
            }
            dp = temp;
        }

        int sum = Integer.MAX_VALUE;
        for (int j = 0; j < l; j++) {
            sum = Math.min(sum, dp[j]);
        }
        return sum;
    }
}
