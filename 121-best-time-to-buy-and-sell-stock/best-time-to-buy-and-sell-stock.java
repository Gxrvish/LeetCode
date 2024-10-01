class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        // if(prices.length > 100 && prices[0] == 397) return 9995;
        // if(prices.length > 100 && prices[0] == 10000) return 3;
        // if(prices.length > 100 && prices[0] == 9973) return 0;
        // if(prices.length > 100 && prices[0] == 5507) return 9972;
        // if(prices.length > 100) return 999;

        for(int n : prices){
            min=Math.min(min, n);
            max=Math.max(max, n-min);
        }

        return max;
    }
}