class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> set = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toCollection(HashSet::new));
        int totalMax = 0;
        for (int num : set) {
            // start counting from the beginning of a sequence
            if (!set.contains(num - 1)) {
                int currNum = num;
                int currMax = 1;
                while (set.contains(currNum + 1)) {
                    currNum++;
                    currMax++;
                }
                totalMax = Math.max(totalMax, currMax);
            }
        }

        return totalMax;
    }
}
