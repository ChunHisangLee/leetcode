// leetcode submit region begin(Prohibit modification and deletion)

class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();

    if (root == null) {
      return res;
    }

    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        TreeNode curr = queue.poll();

        if (i == size - 1) {
          res.add(curr.val);
        }

        if (curr.left != null) {
          queue.offer(curr.left);
        }

        if (curr.right != null) {
          queue.offer(curr.right);
        }
      }
    }

    return res;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
