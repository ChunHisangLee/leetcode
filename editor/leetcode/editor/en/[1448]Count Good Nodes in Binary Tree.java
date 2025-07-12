// leetcode submit region begin(Prohibit modification and deletion)

class Solution {
  public int goodNodes(TreeNode root) {
    return getGoodNodes(root, Integer.MIN_VALUE);
  }

  private int getGoodNodes(TreeNode node, int maxSoFar) {
    if (node == null) {
      return 0;
    }

    int count = node.val >= maxSoFar ? 1 : 0;
    int nextMax = Math.max(maxSoFar, node.val);

    int left = getGoodNodes(node.left, nextMax);
    int right = getGoodNodes(node.right, nextMax);
    return left + right + count;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
