public class Solution {
    public int rob(int[] nums) {
        int prev1 = 0, prev2 = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            int current = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
