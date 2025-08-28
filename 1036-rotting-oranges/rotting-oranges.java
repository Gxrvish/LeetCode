class Solution {
    public int orangesRotting(int[][] grid) {
        return bfs(grid);
    }

    public int bfs(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int minutes = 0;
        while(!q.isEmpty() && fresh > 0) {
            int size = q.size();  // process level by level (1 minute)
            for (int s = 0; s < size; s++) {
                int[] cell = q.poll();
                int r = cell[0], c = cell[1];

                for(int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (isAccessible(nr, nc, rows, cols) 
                        && !visited[nr][nc] 
                        && grid[nr][nc] == 1) {

                        q.add(new int[]{nr, nc});
                        visited[nr][nc] = true;
                        grid[nr][nc] = 2;
                        fresh--;
                    }
                }
            }
            minutes++; // 1 minute after processing current level
        }

        return fresh == 0 ? minutes : -1;
    }

    public boolean isAccessible(int nr, int nc, int row, int column) {
        return nr >= 0 && nr < row && nc >= 0 && nc < column;
    }
}
