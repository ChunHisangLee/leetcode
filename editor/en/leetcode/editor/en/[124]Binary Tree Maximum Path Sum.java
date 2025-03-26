// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  int maxPath = 0;

  public int maxPathSum(TreeNode root) {
    checkPathSum(root);
    return maxPath;
  }

  private int checkPathSum(TreeNode node) {
    if (node == null) {
      return 0;
    }

    if (node.left == null && node.right == null) {
      return 0;
    }

    int leftSum = checkPathSum(node.left);
    int rightSum = checkPathSum(node.right);
    maxPath = Math.max(maxPath, leftSum + rightSum);

    return maxPath;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
