// leetcode submit region begin(Prohibit modification and deletion)

class Solution {
  int result = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    getLength(root);
    return result;
  }

  private int getLength(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int left = getLength(node.left);
    int right = getLength(node.right);
    result = Math.max(result, left + right);
    return Math.max(left, right) + 1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
