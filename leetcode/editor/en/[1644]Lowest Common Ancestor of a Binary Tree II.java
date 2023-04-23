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
    boolean isP = false;
    boolean isQ = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = dfs(root, p, q);
        return isP && isQ ? node : null;
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        if (root == p) {
            isP = true;
            return root;
        }
        if (root == q) {
            isQ = true;
            return root;
        }
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
