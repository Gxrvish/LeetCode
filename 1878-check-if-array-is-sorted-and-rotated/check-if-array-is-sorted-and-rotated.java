class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int rotationPoint = -1;
        
        // Find the first rotation point where order breaks
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (rotationPoint != -1) return false; // More than one rotation point is not valid
                rotationPoint = i + 1;
            }
        }
        
        // If no rotation point is found, the array is already sorted
        if (rotationPoint == -1) return true;

        // Check if the remaining elements after rotationPoint are sorted
        for (int i = rotationPoint; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) return false;
        }

        // Check if the last element correctly connects with the first
        return nums[n - 1] <= nums[0];
    }
}
