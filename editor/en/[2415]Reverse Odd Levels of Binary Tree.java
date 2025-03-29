
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return null;
        }

        dfs(root.left, root.right, 0);
        return root;
    }

    private void dfs(TreeNode left, TreeNode right, int depth) {
        if (left == null && right == null) {
            return;
        }

        if (depth % 2 == 0) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        dfs(left.left, right.right, depth + 1);
        dfs(left.right, right.left, depth + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
