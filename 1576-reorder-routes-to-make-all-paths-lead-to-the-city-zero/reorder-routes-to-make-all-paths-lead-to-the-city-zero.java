class Solution {
    public int minReorder(int n, int[][] connections) {
        // sign = 1 means edge goes u -> v (away from 0, may need to flip)
        // sign = -1 means edge goes v -> u (already toward 0)
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : connections) {
            int u = edge[0], v = edge[1];
            graph[u].add(new int[]{v, 1});   // original u -> v
            graph[v].add(new int[]{u, -1});  // reverse edge, meaning v -> u is good
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    private int dfs(int node, List<int[]>[] graph, boolean[] visited) {
        visited[node] = true;
        int flips = 0;

        for (int[] edge : graph[node]) {
            int neighbor = edge[0], sign = edge[1];
            if (!visited[neighbor]) {
                // If edge sign == 1, it goes away from 0 -> must flip
                flips += (sign == 1 ? 1 : 0);
                flips += dfs(neighbor, graph, visited);
            }
        }
        return flips;
    }
}
