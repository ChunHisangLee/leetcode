// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }

    if (root.left == null && root.right == null) {
      return root.val == targetSum;
    }

    return hasPathSum(root.left, targetSum - root.val)
        || hasPathSum(root.right, targetSum - root.val);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
