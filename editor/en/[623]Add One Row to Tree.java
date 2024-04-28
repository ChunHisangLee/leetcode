//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        insertAtDepth(root, val, depth);
        return root;
    }

    private void insertAtDepth(TreeNode node, int val, int depth) {
        if (node == null) {
            return;
        }

        if (depth == 2) {
            TreeNode tempLeft = node.left;
            TreeNode tempRight = node.right;
            node.left = new TreeNode(val, tempLeft, null);
            node.right = new TreeNode(val, null, tempRight);
        } else {
            insertAtDepth(node.left, val, depth - 1);
            insertAtDepth(node.right, val, depth - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
