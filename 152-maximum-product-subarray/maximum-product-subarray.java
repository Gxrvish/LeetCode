class Solution {
    public int maxProduct(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int prevMax = currMax;
            int prevMin = currMin;

            currMax = Math.max(nums[i], Math.max(nums[i] * prevMax, nums[i] * prevMin));
            currMin = Math.min(nums[i], Math.min(nums[i] * prevMax, nums[i] * prevMin));

            answer = Math.max(answer, currMax);
        }
        return answer;
    }
}
