437
        Path Sum III
        2023-02-24 14:41:59
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
    Map<Long, Integer> map = new HashMap<>();
    int k;
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        k = targetSum;
        map.put(0L, 1);
        dfs(root, 0L);
        return res;
    }

    public void dfs(TreeNode node, long preSum) {
        if (node == null) {
            return;
        }
        preSum += node.val;
        res += map.getOrDefault(preSum - k, 0);
        map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        dfs(node.left, preSum);
        dfs(node.right, preSum);
        map.put(preSum, map.get(preSum) - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
