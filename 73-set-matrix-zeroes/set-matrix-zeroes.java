class Solution {
    public void setZeroes(int[][] matrix) {
        int[][] matrixCopy = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            matrixCopy[i] = matrix[i].clone();
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrixCopy[i][j] == 0) {
                    for (int k = 0; k < matrix.length; k++) {
                        matrix[k][j] = 0;
                    }
                    for (int l = 0; l < matrix[0].length; l++) {
                        matrix[i][l] = 0;
                    }
                }
            }
        }
    }
}