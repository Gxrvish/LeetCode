class Solution {

    public int[] numberGame(int[] nums) {
        Arrays.sort(nums); // Step 1: Sort the array
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < nums.length; i += 2) { // Step 2: Swap pairs
            if (i + 1 < nums.length) {
                answer.add(nums[i + 1]); // Add second element first
                answer.add(nums[i]); // Add first element second
            }
        }

        // Convert List<Integer> to int[]
        int[] output = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            output[i] = answer.get(i);
        }
        return output;
    }
}
