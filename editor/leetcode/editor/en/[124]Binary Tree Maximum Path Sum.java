// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  private int result = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    dfs(root);
    return result;
  }

  private int dfs(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int left = Math.max(dfs(node.left), 0);
    int right = Math.max(dfs(node.right), 0);
    result = Math.max(result, left + right + node.val);
    return Math.max(left, right) + node.val;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
