
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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        inOrderTraversal(root, target, k, deque);

        return new ArrayList<>(deque);
    }

    private void inOrderTraversal(TreeNode node, double target, int k, Deque<Integer> deque) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, target, k, deque);

        if (deque.size() < k) {
            deque.addLast(node.val);
        } else {
            if (Math.abs(deque.peekFirst() - target) > Math.abs(node.val - target)) {
                deque.pollFirst();
                deque.addLast(node.val);
            } else {
                return;
            }
        }

        inOrderTraversal(node.right, target, k, deque);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
