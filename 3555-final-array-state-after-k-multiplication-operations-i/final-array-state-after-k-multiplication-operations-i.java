class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int[] output_arr = new int[nums.length];
        // Copy nums into output_arr
        for (int i = 0; i < nums.length; i++) {
            output_arr[i] = nums[i];
        }
        
        // Repeat the operation k times
        for (int j = 1; j <= k; j++) {
            int minValue = Integer.MAX_VALUE;
            int minIndex = -1;
            
            // Find the minimum value starting from the rightmost side
            for (int i = output_arr.length - 1; i >= 0; i--) {
                if (output_arr[i] <= minValue) {
                    minValue = output_arr[i];
                    minIndex = i;
                }
            }
            
            // Multiply the minimum value by the multiplier
            output_arr[minIndex] = output_arr[minIndex] * multiplier;
        }
        
        return output_arr;
    }
}
