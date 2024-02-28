
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int result = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = deque.poll();

                if (i == 0) {
                    result = curr.val;
                }

                if (curr.left != null) {
                    deque.offer(curr.left);
                }

                if (curr.right != null) {
                    deque.offer(curr.right);
                }
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
