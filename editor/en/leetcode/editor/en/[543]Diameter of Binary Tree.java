// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  int maxDiameter = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    getDiameter(root);
    return maxDiameter;
  }

  private int getDiameter(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int leftDiameter = getDiameter(node.left);
    int rightDiameter = getDiameter(node.right);

    maxDiameter = Math.max(maxDiameter, leftDiameter + rightDiameter);

    return Math.max(leftDiameter, rightDiameter) + 1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
