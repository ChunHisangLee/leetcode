// leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class FindElements {
  private Set<Integer> recoveredValues;

  public FindElements(TreeNode root) {
    recoveredValues = new HashSet<>();

    if (root != null) {
      root.val = 0;
      dfs(root);
    }
  }

  private void dfs(TreeNode node) {
    if (node == null){
      return;
    }

    recoveredValues.add(node.val);

    if (node.left != null) {
      node.left.val = 2 * node.val + 1;
      dfs(node.left);
    }

    if (node.right != null) {
      node.right.val = 2 * node.val + 2;
      dfs(node.right);
    }
  }

  public boolean find(int target) {
    return recoveredValues.contains(target);
  }
}

/**
 * Your FindElements object will be instantiated and called as such: FindElements obj = new
 * FindElements(root); boolean param_1 = obj.find(target);
 */
// leetcode submit region end(Prohibit modification and deletion)
