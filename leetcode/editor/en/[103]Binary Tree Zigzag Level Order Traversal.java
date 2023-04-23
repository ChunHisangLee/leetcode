103
        Binary Tree Zigzag Level Order Traversal
        2022-12-03 16:22:19
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        boolean isLeft = true;
        while (!dq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = dq.poll();
                list.add(node.val);
                if (node.left != null) {
                    dq.add(node.left);
                }
                if (node.right != null) {
                    dq.add(node.right);
                }
            }
            if (!isLeft) {
                Collections.reverse(list);
            }
            res.add(list);
            isLeft = !isLeft;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)