250
        Count Univalue Subtrees
        2022-12-02 13:39:38
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
    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        dfs(root, 0);
        return count;
    }

    private boolean dfs(TreeNode node, int val) {
        if (node == null)
            return true;
        if (!dfs(node.left, node.val) | !dfs(node.right, node.val))
            return false;
        count++;
        return node.val == val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
