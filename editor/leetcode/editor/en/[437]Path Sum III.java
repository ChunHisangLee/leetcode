// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  Map<Long, Integer> prefixMap = new HashMap<>();

  public int pathSum(TreeNode root, int targetSum) {
    prefixMap.put(0L, 1);
    return checkSum(root, targetSum, 0L, prefixMap);
  }

  private int checkSum(TreeNode node, int targetSum, long currSum, Map<Long, Integer> prefixMap) {
    if (node == null) {
      return 0;
    }

    currSum += node.val;
    int count = prefixMap.getOrDefault(currSum - targetSum, 0);

    prefixMap.put(currSum, prefixMap.getOrDefault(currSum, 0) + 1);

    count += checkSum(node.left, targetSum, currSum, prefixMap);
    count += checkSum(node.right, targetSum, currSum, prefixMap);

    prefixMap.put(currSum, prefixMap.get(currSum) - 1);
    return count;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
