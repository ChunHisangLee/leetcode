938
        Range Sum of BST
        2022-12-04 00:18:25
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
        int ans = 0;
        if (root.val >= low && root.val <= high)
            ans += root.val;
        if (root.val > low)
            ans += rangeSumBST(root.left, low, high);
        if (root.val < high)
            ans += rangeSumBST(root.right, low, high);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int ans = 0;

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (low <= node.val && node.val <= high) {
                ans += node.val;
            }
            if (node.left != null && low < node.val) {
                stack.push(node.left);
            }
            if (node.right != null && node.val < high) {
                stack.push(node.right);
            }
        }

        return ans;
    }
}
 */