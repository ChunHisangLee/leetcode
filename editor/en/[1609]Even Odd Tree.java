//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        boolean isEvenLevel = true;

        while (!deque.isEmpty()) {
            int size = deque.size();
            int preValue = isEvenLevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();

                if (isEvenLevel) {
                    if (node.val % 2 == 0 || node.val <= preValue) {
                        return false;
                    }
                } else {
                    if (node.val % 2 != 0 || node.val >= preValue) {
                        return false;
                    }
                }

                preValue = node.val;

                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }

            isEvenLevel = !isEvenLevel;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
