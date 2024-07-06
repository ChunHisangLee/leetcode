
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode[] splitBST(TreeNode root, int target) {
        if (root == null) {
            return new TreeNode[] {null, null};
        }

        TreeNode[] result = new TreeNode[2];

        if (root.val <= target) {
            result[0] = root;
            TreeNode[] splitted = splitBST(root.right, target);
            root.right = splitted[0];
            result[1] = splitted[1];
        } else {
            result[1] = root;
            TreeNode[] splitted = splitBST(root.left, target);
            root.left = splitted[1];
            result[0] = splitted[0];
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
