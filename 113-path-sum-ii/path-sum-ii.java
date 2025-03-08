class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        findPaths(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void findPaths(TreeNode root, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (root == null) return;

        // Add current node to path
        currentPath.add(root.val);

        // If leaf node and sum matches, add path to result
        if (root.left == null && root.right == null && root.val == targetSum) {
            result.add(new ArrayList<>(currentPath)); // Store a copy of the path
        } else {
            findPaths(root.left, targetSum - root.val, currentPath, result);
            findPaths(root.right, targetSum - root.val, currentPath, result);
        }

        // Backtrack: Remove last added node
        currentPath.remove(currentPath.size() - 1);
    }
}
