// leetcode submit region begin(Prohibit modification and deletion)

class Solution {
  public TreeNode recoverFromPreorder(String traversal) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    int i = 0;
    int n = traversal.length();
    while (i < n) {
      int level = 0;
      while (i < n && traversal.charAt(i) == '-') {
        level++;
        i++;
      }

      int start = i;

      while (i < n && Character.isDigit(traversal.charAt(i))) {
        i++;
      }

      int value = Integer.parseInt(traversal.substring(start, i));
      TreeNode node = new TreeNode(value);

      while (stack.size() > level) {
        stack.pop();
      }

      if (!stack.isEmpty()) {
        TreeNode parent = stack.peek();

        if (parent.left == null) {
          parent.left = node;
        } else {
          parent.right = node;
        }
      }

      stack.push(node);
    }

    while (stack.size() > 1) {
      stack.pop();
    }

    return stack.peek();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
