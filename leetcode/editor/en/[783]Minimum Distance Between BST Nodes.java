783
        Minimum Distance Between BST Nodes
        2023-02-17 09:51:20
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
    int min = Integer.MAX_VALUE;
    TreeNode prev;

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return min;
        }
        minDiffInBST(root.left);
        if (prev != null) {
            min = Math.min(min, root.val - prev.val);
        }
        prev = root;
        minDiffInBST(root.right);
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
有存值
class Solution {
    List<Integer> list = new ArrayList<>();

    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            min = Math.min(min, list.get(i + 1) - list.get(i));
        }
        return min;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}
 */