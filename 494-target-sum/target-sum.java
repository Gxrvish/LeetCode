public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return calculate(nums, 0, 0, target);
    }

    private int calculate(int[] nums, int index, int currentSum, int target) {
        // Base Case: If we've processed all elements
        if (index == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        // Recursive Case: Add the current number
        int add = calculate(nums, index + 1, currentSum + nums[index], target);
        // Recursive Case: Subtract the current number
        int subtract = calculate(nums, index + 1, currentSum - nums[index], target);

        // Return total ways from both branches
        return add + subtract;
    }
}
