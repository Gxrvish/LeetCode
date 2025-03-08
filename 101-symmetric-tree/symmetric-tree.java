class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true; // An empty tree is symmetric
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;  // Both null, so symmetric
        if (left == null || right == null) return false; // One is null, not symmetric
        if (left.val != right.val) return false;         // Values don't match

        // Recursively check if left subtree is a mirror of right subtree
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
