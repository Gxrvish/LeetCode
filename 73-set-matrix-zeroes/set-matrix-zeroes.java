class Solution {
    public void setZeroes(int[][] matrix) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int index = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    // Ensure a new list for this index, then add both coords
                    var coords = map.computeIfAbsent(index, _ -> new ArrayList<>());
                    coords.add(i);
                    coords.add(j);

                    index++; // increment only once per zero cell
                }
            }
        }       

        for (var entry : map.entrySet()) {
            // int index = entry.getKey();
            List<Integer> coords = entry.getValue();

            int row = coords.get(0);
            int col = coords.get(1);
            for (int k = 0; k < matrix.length; k++) {
                matrix[k][col] = 0;
            }
            for (int l = 0; l < matrix[0].length; l++) {
                matrix[row][l] = 0;
            }
        }
    }
}