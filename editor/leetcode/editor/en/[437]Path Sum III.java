// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  Map<Long, Integer> prefixMap = new HashMap<>();
  int answer = 0;
  int target;

  public int pathSum(TreeNode root, int targetSum) {
    target = targetSum;
    prefixMap.put(0L, 1);
    dfs(root, 0L);
    return answer;
  }

  private void dfs(TreeNode node, long currSum) {
    if (node == null) {
      return;
    }

    currSum += node.val;
    answer += prefixMap.getOrDefault(currSum - target, 0);
    prefixMap.put(currSum, prefixMap.getOrDefault(currSum, 0) + 1);

    dfs(node.left, currSum);
    dfs(node.right, currSum);

    prefixMap.put(currSum, prefixMap.getOrDefault(currSum, 0) - 1);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
