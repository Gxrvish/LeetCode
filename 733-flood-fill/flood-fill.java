class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length;
        int column = image[0].length;
        boolean[][] visited = new boolean[row][column];
        int startingColor = image[sr][sc];
        bfs(image, visited, color, startingColor, sr, sc);
        return image;
    }
    public void bfs(int[][] grid, boolean[][] visited, int color, int startingColor, int i, int j) {
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;
        grid[i][j] = color;

        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];

            for(int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (isAccessible(nr, nc, grid.length, grid[0].length) 
                    && !visited[nr][nc] 
                    && grid[nr][nc] == startingColor) {
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    grid[nr][nc] = color;
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