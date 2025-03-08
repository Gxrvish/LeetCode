class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true; // Empty tree is symmetric

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) continue; // Both null → symmetric at this level
            if (left == null || right == null || left.val != right.val) return false; // Mismatch

            // Add children in mirror order
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true; // If we never found a mismatch, it's symmetric
    }
}
