// 124
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
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dotheSum(root);
        return max;
    }

    public int dotheSum(TreeNode root) {
        if (root == null)
            return 0;
        int leftMaxPathSum = Math.max(dotheSum(root.left), 0);
        int rightMaxPathSum = Math.max(dotheSum(root.right), 0);
        max = Math.max(max, root.val + leftMaxPathSum + rightMaxPathSum);
        return root.val + Math.max(leftMaxPathSum, rightMaxPathSum);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
