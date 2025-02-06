class Solution {

    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> productCount = new HashMap<>();
        int n = nums.length;
        int result = 0;

        // Iterate over all pairs (i, j)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];

                // If the product exists in the map, calculate the number of valid tuples
                result += productCount.getOrDefault(product, 0) * 8;

                // Store/update the product count
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }

        return result;
    }
}
