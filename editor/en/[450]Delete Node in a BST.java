450
        Delete Node in a BST
        2022-12-27 09:57:36
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode node = findSuccessor(root);
            root.val = node.val;
            root.right = deleteNode(root.right, node.val);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    private TreeNode findSuccessor(TreeNode node) {
        TreeNode curr = node.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
