
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> lonelyNodes = new ArrayList<>();
        dfs(root, lonelyNodes);
        return lonelyNodes;
    }

    private void dfs(TreeNode node, List<Integer> lonelyNodes) {
        if (node == null) {
            return;
        }

        if (node.left != null && node.right == null) {
            lonelyNodes.add(node.left.val);
        }

        if (node.left == null && node.right != null) {
            lonelyNodes.add(node.right.val);
        }

        dfs(node.left, lonelyNodes);
        dfs(node.right, lonelyNodes);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
