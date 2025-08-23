class Solution {
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(grid[i][j] - '0' == 1 && !visited[i][j]) {
                    numOfIslands++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return numOfIslands;
    }
    public void bfs(char[][] grid, boolean[][] visited, int i, int j) {
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;

        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];

            for(int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (isAccessible(nr, nc, grid.length, grid[0].length) 
                    && !visited[nr][nc] 
                    && grid[nr][nc] == '1') {
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }

    public boolean isAccessible(int nr, int nc, int row, int column) {
        if(nr >= 0 && nr < row && nc >= 0 && nc < column) {
            return true;
        }
        return false;
    }
}