// leetcode submit region begin(Prohibit modification and deletion)

class Solution {
  public int closestValue(TreeNode root, double target) {
    int result = root.val;

    while (root != null) {
      double diffRoot = Math.abs(target - root.val);
      double diffResult = Math.abs(target - result);

      if (diffRoot < diffResult || (diffRoot == diffResult && root.val < result)) {
        result = root.val;
      }

      root = target < root.val ? root.left : root.right;
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
