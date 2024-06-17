class Solution {
    public boolean judgeSquareSum(int c) {
        for(double i = 0; i <= Math.sqrt(c); i++) {
            double rem = c - Math.pow(i, 2);
            double sqrt = Math.sqrt(rem);
            if((sqrt - Math.floor(sqrt)) == 0) {
                return true;
            }
        }
        return false;
    }
}