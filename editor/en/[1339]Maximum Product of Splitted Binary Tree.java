1339
        Maximum Product of Splitted Binary Tree
        2022-12-10 09:15:13
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
    private List<Integer> list = new ArrayList<>();

    public int maxProduct(TreeNode root) {
        long totalSum = treeSum(root);
        long rec = 0;
        final int mod = 1_000_000_007;
        for (long sum : list) {
            rec = Math.max(rec, sum * (totalSum - sum));
        }
        return (int) (rec % mod);
    }

    private int treeSum(TreeNode node) {
        if (node == null)
            return 0;
        int left = treeSum(node.left);
        int right = treeSum(node.right);
        int total = node.val + left + right;
        list.add(total);
        return total;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
