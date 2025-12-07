class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n * n; i++) {
            map.put(i, 0);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int current = map.getOrDefault(grid[i][j], 0);
                map.put(grid[i][j], current + 1);
            }
        }
        return new int[]{findKeyByValue(map, 2), findKeyByValue(map, 0)};
    }
    public <K, V> K findKeyByValue(Map<K, V> map, V value) {
        for (var entry : map.entrySet()) {
            if (Objects.equals(entry.getValue(), value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}