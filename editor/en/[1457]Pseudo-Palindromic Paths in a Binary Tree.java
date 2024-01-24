//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int result = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int count) {
        if (root == null) {
            return;
        }

        count ^= (1 << root.val);

        if (root.left == null && root.right == null) {
            if ((count & (count - 1)) == 0) {
                result++;
            }

            return;
        } else {
            dfs(root.left, count);
            dfs(root.right, count);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
