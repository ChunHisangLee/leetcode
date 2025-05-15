// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  int maxPath = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    getMaxPathSum(root);
    return maxPath;
  }

  private int getMaxPathSum(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int leftPathSum = Math.max(getMaxPathSum(node.left), 0);
    int rightPathSum = Math.max(getMaxPathSum(node.right), 0);
    maxPath = Math.max(maxPath, leftPathSum + rightPathSum + node.val);

    return Math.max(leftPathSum, rightPathSum) + node.val;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
