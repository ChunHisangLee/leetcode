// leetcode submit region begin(Prohibit modification and deletion)

class Solution {
  public int widthOfBinaryTree(TreeNode root) {
    int maxWidth = 0;
    Deque<Pair> queue = new ArrayDeque<>();
    queue.offer(new Pair(root, 0));

    while (!queue.isEmpty()) {
      int size = queue.size();
      int first = 0;
      int last = 0;

      for (int i = 0; i < size; i++) {
        Pair curr = queue.poll();

        if (i == 0) {
          first = curr.index;
        }

        if (i == size - 1) {
          last = curr.index;
        }

        if (curr.node.left != null) {
          queue.offer(new Pair(curr.node.left, 2 * curr.index));
        }

        if (curr.node.right != null) {
          queue.offer(new Pair(curr.node.right, 2 * curr.index + 1));
        }
      }

      maxWidth = Math.max(maxWidth, last - first + 1);
    }

    return maxWidth;
  }
}

class Pair {
  TreeNode node;
  int index;

  Pair(TreeNode node, int index) {
    this.node = node;
    this.index = index;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
