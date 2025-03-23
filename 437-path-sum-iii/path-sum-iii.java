import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        AtomicInteger count = new AtomicInteger(0);
        HashMap<Long, Integer> hm = new HashMap<>(); // Use Long instead of Integer
        hm.put(0L, 1); // Base case: sum = 0 appears once
        hasSum(root, count, hm, targetSum, 0L); // Start with sum 0
        return count.get();
    }

    private void hasSum(TreeNode root, AtomicInteger count, HashMap<Long, Integer> hm, int targetSum, long currentSum) {
        if (root == null) return;

        // Update current sum (long to prevent overflow)
        currentSum += root.val;

        // Check if a valid subpath exists
        count.addAndGet(hm.getOrDefault(currentSum - targetSum, 0));

        // Store the current prefix sum in HashMap
        hm.put(currentSum, hm.getOrDefault(currentSum, 0) + 1);

        // Recur for left & right subtrees
        hasSum(root.left, count, hm, targetSum, currentSum);
        hasSum(root.right, count, hm, targetSum, currentSum);

        // Backtrack: Remove current sum from HashMap
        hm.put(currentSum, hm.get(currentSum) - 1);
    }
}
