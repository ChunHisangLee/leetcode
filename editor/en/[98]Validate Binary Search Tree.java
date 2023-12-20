98
Validate Binary
Search Tree
        2022-12-23 13:51:39
//leetcode submit region begin(Prohibit modification and deletion)

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBinaryTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBinaryTree(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return isBinaryTree(node.left, min, node.val) && isBinaryTree(node.right, node.val, max);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
