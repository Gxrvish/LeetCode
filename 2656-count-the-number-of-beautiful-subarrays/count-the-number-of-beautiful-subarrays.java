class Solution {
    public long beautifulSubarrays(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int xor = 0;
        long count = 0;
        for (int num : arr) {
            xor ^= num;
            if (xor == 0) {
                count++;
            }
            int target = xor ^ 0;
            count += map.getOrDefault(target, 0);
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}