class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int output = 0;

        if (nums.length == 1)
            return output;

        // if (nums[0] == nums[1]) {
        //     nums[1]++;
        //     output++;
        // }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i + 1]++;
                output += 1;
            } else if (nums[i] > nums[i + 1]) {
                output = output + (nums[i] - nums[i + 1]) + 1;
                nums[i + 1] = nums[i] + 1;
            }
        }
        return output;
    }
}