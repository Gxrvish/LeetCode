class Solution {
    public int maxProfit(int[] prices) {
        int maxPro=0;
        int currMin=Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++) {
            currMin = Math.min(currMin, prices[i]);
            maxPro = Math.max(maxPro, prices[i] - currMin);
        }
        return maxPro;
    }
}