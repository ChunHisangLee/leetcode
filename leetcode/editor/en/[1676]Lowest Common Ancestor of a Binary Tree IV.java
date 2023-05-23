1676
        Lowest Common Ancestor of a Binary Tree IV
        2022-12-27 16:53:24
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        TreeNode node = dfs(root, nodes);
        return node;
    }

    public TreeNode dfs(TreeNode root, TreeNode[] nodes) {
        if (root == null) {
            return root;
        }
        for (TreeNode node : nodes) {
            if (root == node) {
                return root;
            }
        }
        TreeNode left = dfs(root.left, nodes);
        TreeNode right = dfs(root.right, nodes);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
