113
        Path Sum II
        2023-02-24 14:41:53
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
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<>());
        return res;
    }

    public void dfs(TreeNode node, int target, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.left == null && node.right == null && node.val == target) {
            res.add(new ArrayList<>(list));
        }
        dfs(node.left, target - node.val, list);
        dfs(node.right, target - node.val, list);
        list.remove(list.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
