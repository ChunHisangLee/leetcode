// leetcode submit region begin(Prohibit modification and deletion)

class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();

    if (root == null) {
      return res;
    }

    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> currLevel = new ArrayList<>();

      for (int i = 0; i < size; i++) {
        TreeNode curr = queue.poll();
        currLevel.add(curr.val);

        if (curr.left != null) {
          queue.offer(curr.left);
        }

        if (curr.right != null) {
          queue.offer(curr.right);
        }
      }

      res.add(currLevel);
    }

    return res;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
