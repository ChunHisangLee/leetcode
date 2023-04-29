226
        Invert Binary Tree
        2022-11-28 18:00:44
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
    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }

    public TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = dfs(node.left);
        TreeNode right = dfs(node.right);
        node.left = right;
        node.right = left;
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
