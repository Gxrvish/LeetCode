/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result.size(); // Base case

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Start with root

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes in current level
            List<Integer> levelNodes = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll(); // Remove front node
                levelNodes.add(node.val); // Process the node

                if (node.left != null) queue.offer(node.left); // Add left child
                if (node.right != null) queue.offer(node.right); // Add right child
            }
            result.add(levelNodes); // Add this level to the final result
        }
        return result.size();
    }
}