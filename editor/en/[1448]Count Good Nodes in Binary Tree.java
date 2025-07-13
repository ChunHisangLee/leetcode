
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
  int count = 0;

  public int goodNodes(TreeNode root) {
    dfs(root, Integer.MIN_VALUE);
    return count;
  }

  private void dfs(TreeNode node, int currMax) {
    if (node == null) {
      return;
    }

    if (node.val >= currMax) {
      count++;
      currMax = node.val;
    }

    dfs(node.left, currMax);
    dfs(node.right, currMax);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
