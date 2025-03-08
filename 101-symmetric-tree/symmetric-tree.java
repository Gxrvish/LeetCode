class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) return t1 == t2; // Both null → true, One null → false
        return (t1.val == t2.val) // Check values
            && isMirror(t1.left, t2.right) // Compare opposite children
            && isMirror(t1.right, t2.left); // Compare opposite children
    }
}
