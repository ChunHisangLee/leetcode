270
        Closest Binary Search Tree Value
        2022-12-04 22:35:21
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
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            res = Math.abs(res - target) > Math.abs(root.val - target) ? root.val : res;
            root = root.val > target ? root.left : root.right;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
