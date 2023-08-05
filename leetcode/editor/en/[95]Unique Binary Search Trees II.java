95
        Unique Binary Search Trees II
        2022-12-23 09:34:50
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
    List<TreeNode>[][] dp;

    public List<TreeNode> generateTrees(int n) {
        dp = new ArrayList[n + 1][n + 1];
        return dyP(1, n);
    }

    private List<TreeNode> dyP(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = dyP(start, i - 1);
            List<TreeNode> right = dyP(i + 1, end);
            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    TreeNode node = new TreeNode(i, left.get(j), right.get(k));
                    list.add(node);
                }
            }
        }
        dp[start][end] = list;
        return dp[start][end];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
