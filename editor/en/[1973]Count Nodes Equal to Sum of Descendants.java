
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int result = 0;

    public int equalToDescendants(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = dfs(root.left) + dfs(root.right);

        if (root.val == sum) {
            result++;
        }

        return sum + root.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
