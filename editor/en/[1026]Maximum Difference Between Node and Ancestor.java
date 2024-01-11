
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode node, int max, int min) {
        if (node == null) {
            return max - min;
        }

        int currMax = Math.max(max, node.val);
        int currMin = Math.min(min, node.val);
        int left = dfs(node.left, currMax, currMin);
        int right = dfs(node.right, currMax, currMin);
        return Math.max(left, right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
