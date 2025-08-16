class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] edge : connections) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(new int[]{v, 1});  // needs flip
            graph.get(v).add(new int[]{u, 0});  // correct
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        int flips = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int[] edge : graph.get(node)) {
                int neighbor = edge[0], needsFlip = edge[1];
                if (!visited[neighbor]) {
                    flips += needsFlip;
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
        return flips;
    }
}
