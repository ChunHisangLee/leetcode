// leetcode submit region begin(Prohibit modification and deletion)

class Solution {
  private final List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    checkSum(root, targetSum, new ArrayList<>());
    return result;
  }

  private void checkSum(TreeNode node, int remaining, List<Integer> list) {
    if (node == null) {
      return;
    }

    list.add(node.val);
    remaining -= node.val;

    if (node.left == null && node.right == null && remaining == 0) {
      result.add(new ArrayList<>(list));
    } else {
      checkSum(node.left, remaining, list);
      checkSum(node.right, remaining, list);
    }

    list.remove(list.size() - 1);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
