
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        getSwap(root);
        swap(first, second);
    }

    private void getSwap(TreeNode root) {
        if (root == null) {
            return;
        }
        getSwap(root.left);
        if (prev != null && root.val < prev.val) {
            second = root;
            if (first == null) {
                first = prev;
            }
        }
        prev = root;
        getSwap(root.right);
    }

    private void swap(TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
