class Solution {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int l = 0, r = height.length - 1;
        while(l < r){
                int curr_sum = Math.min(height[l], height[r]) * (r - l);
                if(curr_sum >= max){
                    max = curr_sum;
                }
            if(height[l] <= height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return max;
    }
}