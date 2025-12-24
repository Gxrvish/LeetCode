class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> buckets = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            buckets.computeIfAbsent(size, k -> new ArrayList<>()).add(i);

            // once a bucket reaches required size, flush it
            if (buckets.get(size).size() == size) {
                result.add(buckets.get(size));
                buckets.remove(size);
            }
        }

        return result;
    }
}
