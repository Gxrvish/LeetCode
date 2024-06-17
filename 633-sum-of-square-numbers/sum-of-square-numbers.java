class Solution {
    public boolean judgeSquareSum(int c) {
        long a = 0;
        long b = (long) Math.sqrt(c);
        while(a <= b){
            long val = a*a + b*b;
            if(val > c){
                b--;
            }
            else if(val < c){
                a++;
            }
            else{
                return true;
            }
        }
        return false;
    }
}