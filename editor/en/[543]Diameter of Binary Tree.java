// 543
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
    int result;

    public int diameterOfBinaryTree(TreeNode root) {
        result = 0;
        depth(root);
        return result;
    }

    public int depth(TreeNode node) {
        if (node == null)
            return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        result = Math.max(result, left + right);
        return 1 + Math.max(left, right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
