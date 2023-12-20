
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
    int result = 0;

    public int averageOfSubtree(TreeNode root) {
        postOrder(root);
        return result;
    }

    private int[] postOrder(TreeNode root) {
        if (root == null) {
            return new int[2];
        }

        int[] left = postOrder(root.left);
        int[] right = postOrder(root.right);

        int count = left[0] + right[0] + 1;
        int sum = left[1] + right[1] + root.val;

        if (root.val == sum / count) {
            result++;
        }

        return new int[]{count, sum};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
