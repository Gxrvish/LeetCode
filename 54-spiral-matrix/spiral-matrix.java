class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;
            if (top <= bottom) {
                for (int j = top; j <= bottom; j++) {
                    result.add(matrix[j][right]);
                }
                right--;
                if (left <= right) {                    
                    for (int j = right; j >= left; j--) {
                        result.add(matrix[bottom][j]);
                    }
                    bottom--;
                    if (top <= bottom) {
                        for (int j = bottom; j >= top; j--) {
                            result.add(matrix[j][left]);
                        }
                        left++;
                    }
                }
            }
        }
        return result;
    }
}