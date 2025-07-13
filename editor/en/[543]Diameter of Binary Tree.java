//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getDiameter(root);
        return result;
    }

    private int getDiameter(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDiameter = getDiameter(node.left);
        int rightDiameter = getDiameter(node.right);
        result = Math.max(result, leftDiameter + rightDiameter);
        return Math.max(leftDiameter, rightDiameter) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
