
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left != null) {
                if (current.left.left == null && current.left.right == null) {
                    result += current.left.val;
                } else {
                    queue.offer(current.left);
                }
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
