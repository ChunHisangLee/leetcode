// leetcode submit region begin(Prohibit modification and deletion)

class Solution {
  private int maxLen = 0;

  public int longestUnivaluePath(TreeNode root) {
    dfs(root);
    return maxLen;
  }

  private int dfs(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int leftLen = dfs(node.left);
    int rightLen = dfs(node.right);

    int leftPath = 0;
    if (node.left != null && node.left.val == node.val) {
      leftPath = leftLen + 1;
    }

    int rightPath = 0;
    if (node.right != null && node.right.val == node.val) {
      rightPath = rightLen + 1;
    }

    maxLen = Math.max(maxLen, leftPath + rightPath);
    return Math.max(leftPath, rightPath);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
