1448
        Count Good Nodes in Binary Tree
        2022-12-01 16:23:43
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
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int max) {
        if (node == null)
            return 0;
        int ans = dfs(node.left, Math.max(node.val, max)) + dfs(node.right, Math.max(node.val, max));
        if (node.val >= max)
            ans++;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
