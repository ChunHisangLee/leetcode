// 108
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
    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0)
            return null;
        return toBST(num, 0, num.length - 1);
    }

    public TreeNode toBST(int[] num, int left, int right) {
        if (left > right)
            return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = toBST(num, left, mid - 1);
        node.right = toBST(num, mid + 1, right);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
