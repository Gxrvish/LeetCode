class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0; // Base case: if tree is empty

        int leftDepth = maxDepth(root.left);  // Recursively find depth of left subtree
        int rightDepth = maxDepth(root.right); // Recursively find depth of right subtree
        
        return 1 + Math.max(leftDepth, rightDepth); // Add 1 for current node
    }
}
