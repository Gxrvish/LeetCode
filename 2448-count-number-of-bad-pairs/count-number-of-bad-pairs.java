class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> bag = new HashMap<>();
        long count = 0;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the difference: arr[i] - i
            int diff = nums[i] - i;

            // Merge the diff into the bag, and accumulate the number of good pairs
            // `merge` function: if the diff exists, increment the count, otherwise initialize it to 1
            // count += -1 because if diff exists, the pair (i, j) is good; we add that to count.
            count += -1 + bag.merge(diff, 1, Integer::sum);
        }

        // Calculate the total number of pairs: n * (n - 1) / 2
        int len = nums.length;
        
        // The total number of pairs is (n choose 2), we subtract the count of good pairs to get bad pairs
        return 1L * len * (len - 1) / 2 - count;
    }
}
