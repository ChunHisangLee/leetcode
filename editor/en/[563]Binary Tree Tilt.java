
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    private int result = 0;

    public int findTilt(TreeNode root) {
        checkTilt(root);
        return result;
    }

    private int checkTilt(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = checkTilt(node.left);
        int rightSum = checkTilt(node.right);
        result += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + node.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
