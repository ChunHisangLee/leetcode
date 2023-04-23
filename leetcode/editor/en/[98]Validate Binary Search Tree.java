98
        Validate Binary Search Tree
        2022-12-23 13:51:39
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
    public boolean isValidBST(TreeNode root) {
        retrun isBST (root, null, null);
    }

    public boolean isBST(TreeNode node, Integer left, Integer right) {
        if (node == null) {
            return true;
        }
        if ((left != null && node.val <= left) || (right != null && node.val >= right)) {
            return false;
        }
        return isBST(node.left, left, node.val) && isBST(node.right, node.val, node.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
