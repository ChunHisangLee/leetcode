// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    int rootVal = root.val;
    int pVal = p.val;
    int qVal = q.val;

    if (pVal < rootVal && qVal < rootVal) {
      return lowestCommonAncestor(root.left, p, q);
    }

    if (pVal > rootVal && qVal > rootVal) {
      return lowestCommonAncestor(root.right, p, q);
    }

    return root;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
