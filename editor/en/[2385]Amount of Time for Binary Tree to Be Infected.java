//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int max = 0;
    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        return max;
    }

    public int dfs(TreeNode node, int start) {
        int depth = 0;

        if (node == null) {
            return depth;
        }

        int leftDepth = dfs(node.left, start);
        int rightDepth = dfs(node.right, start);

        if (node.val == start) {
            max = Math.max(leftDepth, rightDepth);
            depth = -1;
        } else if (leftDepth >= 0 && rightDepth >= 0) {
            depth = Math.max(leftDepth, rightDepth) + 1;
        } else {
            int distance = Math.abs(leftDepth) + Math.abs(rightDepth);
            max = Math.max(max, distance);
            depth = Math.min(leftDepth, rightDepth) - 1;
        }

        return depth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
