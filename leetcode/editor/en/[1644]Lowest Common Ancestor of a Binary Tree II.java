1644
        Lowest Common Ancestor of a Binary Tree II
        2022-12-27 16:53:19
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
    int count = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = dfs(root, p, q);
        return count == 2 ? node : null;
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        if (root == p || root == q) {
            count++;
            return root;
        }
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
