// 1008
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
    int nodeIndex;

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null)
            return null;
        nodeIndex = 0;
        return toBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode toBST(int[] preorder, int left, int right) {
        if (nodeIndex == preorder.length || preorder[nodeIndex] < left || preorder[nodeIndex] > right) {
            return null;
        }
        int val = preorder[nodeIndex++];
        TreeNode node = new TreeNode(val);
        node.left = toBST(preorder, left, val);
        node.right = toBST(preorder, val, right);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
