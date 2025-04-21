// leetcode submit region begin(Prohibit modification and deletion)

class Solution {
  private List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    checkSum(root, targetSum, new ArrayList<>());
    return result;
  }

  private void checkSum(TreeNode node, int targetSum, List<Integer> list) {
    if (node == null) {
      return;
    }

    list.add(node.val);

    if (node.left == null && node.right == null && node.val == targetSum) {
      result.add(new ArrayList<>(list));
    } else {
      checkSum(node.left, targetSum - node.val, list);
      checkSum(node.right, targetSum - node.val, list);
    }

    list.remove(list.size() - 1);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
