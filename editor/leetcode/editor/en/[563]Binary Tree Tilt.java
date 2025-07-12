// leetcode submit region begin(Prohibit modification and deletion)

class Solution {
  private int result = 0;

  public int findTilt(TreeNode root) {
    getDiffNum(root);
    return result;
  }

  private int getDiffNum(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int left = getDiffNum(node.left);
    int right = getDiffNum(node.right);
    result += Math.abs(left - right);
    return left + right + node.val;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
