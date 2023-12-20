
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
    double max = 0;

    public double maximumAverageSubtree(TreeNode root) {
        postOrder(root);
        return max;
    }

    private int[] postOrder(TreeNode root) {
        if (root == null) {
            return new int[2];
        }

        int[] left = postOrder(root.left);
        int[] right = postOrder(root.right);

        int count = left[0] + right[0] + 1;
        int sum = left[1] + right[1] + root.val;
        max = Math.max(max, (double) sum / count);

        return new int[]{count, sum};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
