
//leetcode submit region begin(Prohibit modification and deletion)

public class Solution {
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

    boolean isLeftValid = checkBST(node.left, min, node.val);
    boolean isRightValid = checkBST(node.right, node.val, max);

    return isLeftValid && isRightValid;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
