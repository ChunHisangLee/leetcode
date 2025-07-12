// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();

    if (root == null) {
      return res;
    }

    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    boolean leftToRight = true;

    while (!queue.isEmpty()) {
      int size = queue.size();
      Deque<Integer> currLevel = new ArrayDeque<>();

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();

        if (leftToRight) {
          currLevel.addLast(node.val);
        } else {
          currLevel.addFirst(node.val);
        }

        if (node.left != null) {
          queue.offer(node.left);
        }

        if (node.right != null) {
          queue.offer(node.right);
        }
      }

      res.add(new ArrayList<>(currLevel));
      leftToRight = !leftToRight;
    }

    return res;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
