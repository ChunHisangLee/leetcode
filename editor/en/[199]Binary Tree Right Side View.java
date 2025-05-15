
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);

        while (!dq.isEmpty()) {
            int size = dq.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = dq.poll();

                if (i == size - 1) {
                    list.add(curr.val);
                }

                if (curr.left != null) {
                    dq.add(curr.left);
                }

                if (curr.right != null) {
                    dq.add(curr.right);
                }
            }
        }

        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
