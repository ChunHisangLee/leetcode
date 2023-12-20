958
        Check Completeness of a Binary Tree
        2023-02-18 10:22:41
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> dq = new LinkedList<>();
        boolean isNull = false;
        dq.add(root);
        while (!dq.isEmpty()) {
            TreeNode node = dq.poll();
            if (node == null) {
                isNull = true;
            } else {
                if (isNull) {
                    return false;
                }
                dq.add(node.left);
                dq.add(node.right);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
