// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  int maxPath = 0;

  public int longestUnivaluePath(TreeNode root) {
    checkLength(root);
    return maxPath;
  }

  private int checkLength(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int leftLength = checkLength(node.left);
    int rightLength = checkLength(node.right);
    int leftPath = 0;
    int rightPath = 0;

    if (node.left != null && node.left.val == node.val) {
      leftPath = leftLength + 1;
    }

    if (node.right != null && node.right.val == node.val) {
      rightPath = rightLength + 1;
    }

    maxPath = Math.max(maxPath, leftPath + rightPath);
    return Math.max(leftPath, rightPath);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
