1161
        Maximum Level Sum of a Binary Tree
        2022-12-24 10:33:48
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
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        int max = Integer.MIN_VALUE;
        int index = 1;
        int res = 1;
        while (!dq.isEmpty()) {
            int currLen = dq.size();
            int sum = 0;
            for (int i = 0; i < currLen; i++) {
                TreeNode node = dq.remove();
                sum += node.val;
                if (node.left != null) {
                    dq.add(node.left);
                }
                if (node.right != null) {
                    dq.add(node.right);
                }
            }
            if (sum > max) {
                max = sum;
                res = index;
            }
            index++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
