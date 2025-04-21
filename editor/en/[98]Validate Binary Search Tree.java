
//leetcode submit region begin(Prohibit modification and deletion)

public class Solution {
  public boolean isValidBST(TreeNode root) {
    return checkValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean checkValid(TreeNode node, long min, long max) {
    if (node == null) {
      return true;
    }

    if (node.val <= min || node.val >= max) {
      return false;
    }

    return checkValid(node.left, min, node.val) && checkValid(node.right, node.val, max);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
