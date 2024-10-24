
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        int curLvlSum = root.val;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        root.val *= -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int newLvlSum = 0;

            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                int childSum = 0;

                if (cur.left != null) {
                    childSum += cur.left.val;
                }

                if (cur.right != null) {
                    childSum += cur.right.val;
                }

                newLvlSum += childSum;

                if (cur.left != null) {
                    cur.left.val = -childSum;
                }

                if (cur.right != null) {
                    cur.right.val = -childSum;
                }

                cur.val += curLvlSum;

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

            curLvlSum = newLvlSum;
        }

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
