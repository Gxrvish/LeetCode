class Solution {

    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int maxSum = -1; // Store the maximum sum of valid pairs

        for (int i = 0; i < nums.length; i++) {
            int sum = digitSum(nums[i]);

            if (hm.containsKey(sum)) {
                int j = hm.get(sum);
                maxSum = Math.max(maxSum, nums[i] + nums[j]);

                // Update hashmap to store the larger value for future comparisons
                if (nums[i] > nums[j]) {
                    hm.put(sum, i);
                }
            } else {
                hm.put(sum, i);
            }
        }

        return maxSum;
    }

    // Helper function to calculate digit sum
    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
