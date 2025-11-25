class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        // Add [1]
        result.add(new ArrayList<>(List.of(1)));
        if (numRows == 1) return result;
        // Add [1, 1]
        result.add(new ArrayList<>(List.of(1, 1)));
        if (numRows == 2) return result;
        for (int i = 2; i < numRows; i++) {
            List<Integer> current = new ArrayList<>();
            current.add(1);
            List<Integer> previous = result.get(i - 1);
            for (int j = 1; j < i; j++) {
                current.add(previous.get(j-1) + previous.get(j));
            }
            current.add(1);
            result.add(current);
        }
        return result;
    }
}