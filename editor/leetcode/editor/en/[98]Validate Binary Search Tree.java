// leetcode submit region begin(Prohibit modification and deletion)

class Solution {
  public boolean isValidBST(TreeNode root) {
    return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean checkBST(TreeNode node, long min, long max) {
    if (node == null) {
      return true;
    }

    if (node.val <= min || node.val >= max) {
      return false;
    }

    return checkBST(node.left, min, node.val) && checkBST(node.right, node.val, max);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
