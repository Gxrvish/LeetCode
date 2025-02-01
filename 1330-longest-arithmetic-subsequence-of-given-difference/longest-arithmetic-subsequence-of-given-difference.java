class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int result = 0;
        for (int num : arr) {
            int current = dp.getOrDefault(num - difference, 0) + 1;
            dp.put(num, current);
            result = Math.max(result, current);
        }
        return result;
    }
}