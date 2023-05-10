class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> output_arr = new ArrayList();
        
        if(matrix.length == 0) return output_arr;
        int rowBegin = 0, rowEnd = matrix.length - 1, columnBegin = 0, columnEnd = matrix[0].length - 1;
        while(rowBegin <= rowEnd && columnBegin <= columnEnd) {
            for(int i = columnBegin; i <= columnEnd; i++) {
                output_arr.add(matrix[rowBegin][i]);
            }
            
            rowBegin++;
            
            for(int i = rowBegin; i <= rowEnd; i++) {
                output_arr.add(matrix[i][columnEnd]);
            }
            
            columnEnd--;
            
            if(rowBegin <= rowEnd) {
                for(int i = columnEnd; i >= columnBegin; i--) {
                    output_arr.add(matrix[rowEnd][i]);
                }
                
                rowEnd--;
                    
            }
            
            if(columnBegin <= columnEnd) {
                for(int i = rowEnd; i >= rowBegin; i--) {
                    output_arr.add(matrix[i][columnBegin]);
                }
                
                columnBegin++;
                
            }
        }
        
        return output_arr;
    }
}