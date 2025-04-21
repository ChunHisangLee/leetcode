// leetcode submit region begin(Prohibit modification and deletion)

class Solution {
  private int result = 0;

  public int longestUnivaluePath(TreeNode root) {
    getPath(root);
    return result;
  }

  private int getPath(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int leftPath = getPath(node.left);
    int rightPath = getPath(node.right);
    int left = 0;
    int right = 0;

    if (node.left != null && node.val == node.left.val) {
      left = leftPath + 1;
    }

    if (node.right != null && node.val == node.right.val) {
      right = rightPath + 1;
    }

    result = Math.max(result, left + right);
    return Math.max(left, right);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
