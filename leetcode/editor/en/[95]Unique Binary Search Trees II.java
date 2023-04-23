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
    List<TreeNode>[][] dp = new ArrayList[10][10];

    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        if (dp[start][end] == null) {
            for (int i = start; i <= end; i++) {
                List<TreeNode> left = helper(start, i - 1);
                List<TreeNode> right = helper(i + 1, end);
                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        TreeNode newNode = new TreeNode(i, left.get(j), right.get(k));
                        res.add(newNode);
                    }
                }
            }
            dp[start][end] = res;
        }
        return dp[start][end];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
