// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }

    if (root.left == null && root.right == null) {
      return targetSum == root.val;
    }

    int remainingSum = targetSum - root.val;

    return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
