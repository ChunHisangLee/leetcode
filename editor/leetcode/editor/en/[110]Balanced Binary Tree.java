// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public boolean isBalanced(TreeNode root) {
    return checkHeight(root) != -1;
  }

  private int checkHeight(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int leftHeight = checkHeight(node.left);
    if (leftHeight == -1) {
      return -1;
    }

    int rightHeight = checkHeight(node.right);
    if (rightHeight == -1) {
      return -1;
    }

    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }

    return Math.max(leftHeight, rightHeight) + 1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
