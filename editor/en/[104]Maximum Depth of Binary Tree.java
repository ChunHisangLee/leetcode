// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Deque<TreeNode> queue = new ArrayDeque<>();
    int depth = 0;
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();

        if (node.left != null) {
          queue.offer(node.left);
        }

        if (node.right != null) {
          queue.offer(node.right);
        }
      }

      depth++;
    }

    return depth;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
