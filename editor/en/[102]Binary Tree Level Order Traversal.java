
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> subResult = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode curr = queue.poll();
        subResult.add(curr.val);

        if (curr.left != null) {
          queue.offer(curr.left);
        }

        if (curr.right != null) {
          queue.offer(curr.right);
        }
      }
      result.add(subResult);
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
