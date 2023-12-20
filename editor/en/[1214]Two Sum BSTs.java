
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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        return dfs(root1, root2, target);
    }

    private boolean dfs(TreeNode root, TreeNode root2, int target) {
        if (root == null) {
            return false;
        }
        if (contains(root2, target - root.val)) {
            return true;
        }
        return dfs(root.left, root2, target) || dfs(root.right, root2, target);
    }

    private boolean contains(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        } else if (root.val < target) {
            return contains(root.right, target);
        } else {
            return contains(root.left, target);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
