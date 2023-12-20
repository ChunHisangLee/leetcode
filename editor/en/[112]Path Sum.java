112
        Path Sum
        2022-12-01 13:53:56
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }

    public boolean dfs(TreeNode node, int target) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return node.val == target;
        }
        return dfs(node.left, target - node.val) || dfs(node.right, target - node.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
