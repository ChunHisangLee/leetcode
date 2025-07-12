// leetcode submit region begin(Prohibit modification and deletion)

class Solution {
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }

    TreeNode leftSubTree = invertTree(root.left);
    TreeNode rightSubTree = invertTree(root.right);

    root.left = rightSubTree;
    root.right = leftSubTree;

    return root;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
